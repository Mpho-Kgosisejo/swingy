package packages.gui.views;

import javax.swing.JFrame;

public class GameSimulationView extends JFrame
{
    public GameSimulationView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game Simulation");
        this.setSize(600, 260);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}