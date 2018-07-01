package packages.gui.views;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameSimulationView extends JFrame
{
    private JPanel mainPanel;
    public GameSimulationView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game Simulation");
        this.setSize(1000, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.init();
    }

    public void init()
    {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
    }
}