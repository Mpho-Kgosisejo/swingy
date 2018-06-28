package packages.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import packages.gui.controllers.SelectHeroController;
import packages.utils.JFrameHelper;

public class SelectHeroView extends JFrame{
    private JPanel panelRight;
    private JPanel panelRightTop;
    private JList<String> lstHeroNames;
    private JButton btnCreateHero;
    private JButton btnLoadHeroInfo;
    private JLabel lblHeroName;
    private JTextArea txtAHeroInfo;
    private JButton btnSelectHero;
    private int listIndex = -1;

    private Image heroImage;
    private JLabel lblHeroImage;

    public SelectHeroView(DefaultListModel <String> herosList){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Select Hero");
        this.setSize(600, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.init(herosList);
        new SelectHeroController(this);
    }

    private void init(DefaultListModel <String> herosList){
        this.panelRight = new JPanel();
        JPanel panelMain = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelLeftControllers = new JPanel();
        this.panelRightTop = new JPanel();
        JPanel panelRightMid = new JPanel();
        JPanel panelRightBottom = new JPanel();
        this.lstHeroNames = new JList<String>(herosList);
        this.btnCreateHero = new JButton("Create New Hero");
        this.btnLoadHeroInfo = new JButton("Load Hero...");
        this.lblHeroName = new JLabel("<- ->");
        this.txtAHeroInfo = new JTextArea("<- ->");
        this.btnSelectHero = new JButton("Select Hero");

        panelMain.setLayout(new GridLayout(1, 2));
        panelMain.setSize(new Dimension(this.getWidth(), this.getHeight()));
        panelLeft.setBackground(new Color(255, 229, 204));
        panelLeft.setLayout(null);
        this.panelRight.setBackground(new Color(204, 229, 255));
        this.panelRight.setLayout(null);
        this.lstHeroNames.setBounds(10, 10, ((panelMain.getWidth() / 2) - 20), 230);
        panelLeftControllers.setBackground(new Color(204, 204, 255));
        panelLeftControllers.setBounds(0, 240, (panelMain.getWidth() / 2), 60);
        this.panelRightTop.setBounds(0, 0, (panelMain.getWidth() / 2), 70);
        this.panelRightTop.setBackground(new Color(204, 255, 229));
        panelRightMid.setBounds(0, 70, (panelMain.getWidth() / 2), 170);
        panelRightMid.setLayout(null);
        panelRightMid.setBackground(new Color(255, 204, 229));
        panelRightBottom.setBounds(0, 240, (panelMain.getWidth() / 2), 50);
        panelRightBottom.setBackground(new Color(255, 255, 204));
        this.txtAHeroInfo.setBounds(10, 0, ((panelMain.getWidth() / 2) - 20), 170);
        this.txtAHeroInfo.setEditable(false);
        this.lblHeroImage = new JLabel();
        this.lblHeroImage.setBackground(new Color(0, 0, 0));
        this.lblHeroImage.setSize(10, 10);
        
        if (this.setImage("/goinfre/mkgosise/Downloads/check-box-empty.png")){
            this.panelRightTop.add(this.lblHeroImage);
        }

        panelLeftControllers.add(this.btnCreateHero);
        panelLeftControllers.add(this.btnLoadHeroInfo);
        panelLeft.add(this.lstHeroNames);
        panelLeft.add(panelLeftControllers);
        this.panelRightTop.add(this.lblHeroName);
        panelRightMid.add(this.txtAHeroInfo);
        panelRightBottom.add(this.btnSelectHero);
        panelMain.add(panelLeft);
        panelMain.add(this.panelRight);
        panelRight.add(this.panelRightTop);
        panelRight.add(panelRightMid);
        panelRight.add(panelRightBottom);

        this.btnSelectHero.setEnabled(false);
        this.add(panelMain);
    }

    private boolean setImage(String imagePath){
        try{
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(imagePath)));
            Image image = imageIcon.getImage();
            this.heroImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            this.lblHeroImage.setIcon(new ImageIcon(this.heroImage));
            return (true);
        }catch(Exception exc){
            System.err.println("Error Setting Image: " + exc.getMessage());
        }
        //this.panelRightTop.remove(this.lblHeroImage);
        return (false);
    }

    //#region - Listener
    public void navigateToCreateHeroListener(ActionListener action){
        this.btnCreateHero.addActionListener(action);
    }

    public void loadHeroListener(ActionListener action){
        this.btnLoadHeroInfo.addActionListener(action);
    }

    public void selectHeroListener(ActionListener action){
        this.btnSelectHero.addActionListener(action);
    }

    public void heroClickListener(MouseListener listener){
        this.lstHeroNames.addMouseListener(listener);
    }
    //#endregion

    public int getMouseClickIndex(){
        return (this.listIndex);
    }

    public void setMouseClickIndex(Point point){
        this.listIndex = lstHeroNames.locationToIndex(point);
    }

    //ToDo: Pass => interface [Hero()]
    public void setSelectedHero(){
        this.btnSelectHero.setEnabled(true);
        this.lblHeroName.setText("<- Hero Name ->");
        this.txtAHeroInfo.setText("<- Hero Info ->");

        if (!this.setImage("/goinfre/mkgosise/Downloads/default-image.png")){
            JFrameHelper.ShowErrorDialog(this, "Error setting Hero Image.");
        }else{
            
        }
    }
}