package packages.gui.views;

import javax.swing.JFrame;

public class CreateHeroView extends JFrame{

    public CreateHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Hero");
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}