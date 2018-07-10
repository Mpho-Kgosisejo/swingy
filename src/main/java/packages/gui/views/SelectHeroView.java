package packages.gui.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import packages.gui.controllers.SelectHeroController;
import packages.models.HeroModel;
import packages.providers.Cache;
import packages.utils.JFrameHelper;
import packages.utils.Log;
import packages.utils.SwingyIO;

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
    private List<HeroModel> heroList;
    private JLabel lblHeroImage;

    public SelectHeroView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Select Hero");
        this.setSize(600, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.heroList = Cache.HeroList;
        this.init(getHeroNames());
    }

    private DefaultListModel<String> getHeroNames(){
        DefaultListModel<String> list = new DefaultListModel<String>();
        try {
            for (HeroModel hero : this.heroList) {
              list.addElement(hero.getName());
            }
          } catch (Exception exc) {
            exc.printStackTrace();
          }
        return (list);
    }

    private void init(DefaultListModel<String> herosList){
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
        this.lblHeroName = new JLabel();
        this.txtAHeroInfo = new JTextArea();
        this.btnSelectHero = new JButton("Select Hero");

        panelMain.setLayout(new GridLayout(1, 2));
        panelMain.setSize(new Dimension(this.getWidth(), this.getHeight()));
        panelLeft.setLayout(null);
        this.panelRight.setLayout(null);
        this.lstHeroNames.setBounds(10, 10, ((panelMain.getWidth() / 2) - 20), 230);
        panelLeftControllers.setBounds(0, 240, (panelMain.getWidth() / 2), 60);
        this.panelRightTop.setBounds(0, 0, (panelMain.getWidth() / 2), 70);
        panelRightMid.setBounds(0, 70, (panelMain.getWidth() / 2), 170);
        panelRightMid.setLayout(null);
        panelRightBottom.setBounds(0, 240, (panelMain.getWidth() / 2), 50);
        this.txtAHeroInfo.setBounds(10, 0, ((panelMain.getWidth() / 2) - 20), 170);
        this.txtAHeroInfo.setEditable(false);
        this.lblHeroImage = new JLabel();
        this.lblHeroImage.setSize(10, 10);
        
        this.panelRightTop.add(this.lblHeroImage);
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

    public int getMouseClickIndex(){
        return (this.listIndex);
    }

    public void setMouseClickIndex(Point point){
        this.listIndex = lstHeroNames.locationToIndex(point);
    }

    public void setHeroInfo(String heroName, String info, String imagePath){
        this.lblHeroName.setText(heroName);
        this.txtAHeroInfo.setText(info);
        this.lblHeroImage.setIcon(new ImageIcon(JFrameHelper.getImage(imagePath, 60)));
        this.btnSelectHero.setEnabled(true);
    }
}