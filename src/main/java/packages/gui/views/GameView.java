package packages.gui.views;

import javax.swing.JFrame;

public class GameView extends JFrame{

    public GameView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}