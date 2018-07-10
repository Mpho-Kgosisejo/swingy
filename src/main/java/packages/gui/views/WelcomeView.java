package packages.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import packages.gui.controllers.WelcomeController;

public class WelcomeView extends JFrame{
    private JLabel lblWelcomeMssg;
    private JButton btnSelectHero;
    private JButton btnCreateNewHero;
    private JFrame jFrameWelcomeView;

    public WelcomeView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Welcome to... who cares");
        this.setSize(400, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jFrameWelcomeView = this;

        this.init();
    }

    private void init(){
        this.lblWelcomeMssg = new JLabel("Welcome...", SwingConstants.LEFT);
        this.btnSelectHero = new JButton("Select Hero");
        this.btnCreateNewHero = new JButton("Create Hero");

        JPanel panelMain = new JPanel();
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();

        panelMain.setLayout(null);
        panelMain.setSize(new Dimension(this.getWidth(), this.getHeight()));
        panelTop.setBackground(new Color(228, 228, 228));
        panelTop.setBounds(0, 0, this.getWidth(), 50);
        panelBottom.setBounds(0, 50, this.getWidth(), 100);
        
        panelTop.add(this.lblWelcomeMssg);
        panelBottom.add(this.btnSelectHero);
        panelBottom.add(this.btnCreateNewHero);
        panelMain.add(panelTop);
        panelMain.add(panelBottom);
        
        this.add(panelMain);
    }

    public void navigateToSelectHeroListener(ActionListener action){
        this.btnSelectHero.addActionListener(action);
    }

    public void navigateToCreateHeroListener(ActionListener action){
        this.btnCreateNewHero.addActionListener(action);
    }
}