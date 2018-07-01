package packages.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class GameSimulationView extends JFrame
{
    private JPanel mainPanel;
    private JPanel imagePanel1;
    private JPanel imagePanel2;

    public GameSimulationView()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Game Simulation");
        this.setSize(1000, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
        this.init();
    }

    public void init()
    {
        // this.imagePanel1 = new JPanel();
        // this.imagePanel1 = new JPanel();
        // this.mainPanel = new JPanel();

        // this.add(this.imagePanel1);
        // this.add(this.imagePanel2);
        // this.add(this.mainPanel);
        // this.setLayout(new GridLayout(3,3));        

    }
}