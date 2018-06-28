package packages.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import packages.gui.controllers.SelectHeroController;

public class SelectHeroView extends JFrame{
    private JPanel panelRight;
    private JList<String> lstHeroNames;
    private JButton btnCreateHero;
    private JButton btnLoadHeroInfo;
    private int listIndex = -1;

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
        this.lstHeroNames = new JList<String>(herosList);
        this.btnCreateHero = new JButton("Create New Hero");
        this.btnLoadHeroInfo = new JButton("Load Hero...");

        panelMain.setLayout(new GridLayout(1, 2));
        panelMain.setSize(new Dimension(this.getWidth(), this.getHeight()));
        panelLeft.setBackground(new Color(255, 229, 204));
        panelLeft.setLayout(null);
        this.panelRight.setBackground(new Color(204, 229, 255));
        this.lstHeroNames.setBounds(0, 0, (panelMain.getWidth() / 2), 240);
        panelLeftControllers.setBackground(new Color(204, 204, 255));
        panelLeftControllers.setBounds(0, 240, (panelMain.getWidth() / 2), 60);

        panelLeftControllers.add(this.btnCreateHero);
        panelLeftControllers.add(this.btnLoadHeroInfo);
        panelLeft.add(this.lstHeroNames);
        panelLeft.add(panelLeftControllers);
        panelMain.add(panelLeft);
        panelMain.add(this.panelRight);

        this.add(panelMain);
    }

    public void navigateToCreateHeroListener(ActionListener action){
        this.btnCreateHero.addActionListener(action);
    }

    public void loadHeroListener(ActionListener action){
        this.btnLoadHeroInfo.addActionListener(action);
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
}