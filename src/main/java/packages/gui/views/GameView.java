package packages.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.PlainDocument;

import packages.gui.controllers.SelectHeroController;
import packages.models.HeroModel;
import packages.utils.Formulas;
import packages.utils.readFile;

public class GameView extends JFrame{
    //H: 1080, W: 1920 (Current Mac - screen size)
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private HeroModel hero;
    private JFrame thisFrame;

    public GameView(HeroModel hero){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Game");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.thisFrame = this;
        System.out.println("Game View is proper, Windows: " + thisFrame.getComponentCount());
        System.out.println("Game View is proper, Windows: " + this.getComponentCount());        
        if (thisFrame.getComponentCount() > 1)
        {
            System.out.print("Multiple windows");
            thisFrame.setVisible(false);
        }

        this.hero = hero;
        this.init();        

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                List<HeroModel> heroList = null;
                try{
                    heroList = readFile.simulateFile("test.txt");
                }catch(Exception exc){

                }
                SelectHeroView selectHeroView = new SelectHeroView(heroList);
                selectHeroView.setVisible(true);
                new SelectHeroController(selectHeroView, heroList);
                thisFrame.dispose();
            }
        });
    }

    private void init(){
        int mapSize = Formulas.sizeMap(this.hero.getLevel());
        this.setSize(500, 500);
        JPanel panelMain = new JPanel();
        panelMain.setBackground(new Color(255, 255, 255));
        panelMain.setLayout(new GridLayout(mapSize, mapSize, 2, 2));
        panelMain.setBounds(5, 5, (this.getWidth() - 10), (this.getHeight() - 10));

        System.out.println("Hero Level: " + this.hero.getLevel());
        for (int y = 0; y < mapSize; y++){
            for (int x = 0; x < mapSize; x++){
                //System.out.println("Y: " + y + ", X: " + x);
                panelMain.add(new JPanel());
            }   
        }
        System.out.println("H: " + screenSize.height + ", W: " + screenSize.width);
        this.add(panelMain);
    }

    public HeroModel getHero(){
         return (this.hero);
    }
}