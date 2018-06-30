package packages.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packages.console.controller.Coordinates;
import packages.gui.controllers.SelectHeroController;
import packages.models.HeroModel;
import packages.utils.Formulas;
import packages.utils.UpdateFile;
import packages.utils.WriteFile;
import packages.utils.readFile;

public class GameView extends JFrame{
    //H: 1080, W: 1920 (Current Mac - screen size)
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private HeroModel hero;
    private JFrame thisFrame;
    private JLabel lblHeroImage;
    private JPanel panelMain;
    private List<HeroModel> _heroList;
    private int mapSize = 0;

    public GameView(HeroModel hero){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Game");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.thisFrame = this;
        try {
            _heroList = readFile.simulateFile();
        }
        catch (IOException e)
        {
            System.out.println("hehehehehe");
        }

        if (thisFrame.getComponentCount() > 1)
        {
            thisFrame.setVisible(false);
        }

        
        this.hero = hero;
        WriteFile.findAndUpdate(_heroList, this.hero);
        this.init();        

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                List<HeroModel> heroList = null;
                try{
                    heroList = readFile.simulateFile();
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
        this.mapSize = Formulas.sizeMap(this.hero.getLevel());

        this.setSize(800, 800);
        panelMain = new JPanel();
        panelMain.setBackground(new Color(255, 255, 255));
        panelMain.setLayout(new GridLayout(this.mapSize, this.mapSize, 1, 1));
        panelMain.setBounds(5, 5, (this.getWidth() - 10), (this.getHeight() - 10));
        this.lblHeroImage = new JLabel();

        this.hero.setCoordinates(new Coordinates((this.mapSize / 2), (this.mapSize / 2)));
        this.drawMap();

        this.add(panelMain);
    }

    public void drawMap(){
        Random rand = new Random();
        this.panelMain.removeAll();
        
        for (int y = 0; y < this.mapSize; y++){
            for (int x = 0; x < this.mapSize; x++){
                JPanel panel = new JPanel();
                panelMain.add(panel);
                if (this.hero.getCoordinates().getY() == y && this.hero.getCoordinates().getX() == x){
                    this.setImage(hero.getIcon());
                    panel.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                    panel.add(this.lblHeroImage);
                }
                this.panelMain.add(panel);
            }   
        }
        this.panelMain.revalidate();
        this.panelMain.repaint();
    }

    private boolean setImage(String imagePath){
        try{
            int imageSize = ((this.getWidth() / Formulas.sizeMap(this.hero.getLevel())) - 12);
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(imagePath)));
            Image image = imageIcon.getImage();
            Image heroImage = image.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
            this.lblHeroImage.setIcon(new ImageIcon(heroImage));
            return (true);
        }catch(Exception exc){
            System.err.println("Error Setting Image: " + exc.getMessage());
        }
        return (false);
    }

    public HeroModel getHero(){
         return (this.hero);
    }

    public void setKeyListener(KeyListener listener){
        this.addKeyListener(listener);
    }

    public int getMapSize(){
        return (this.mapSize);
    }
}