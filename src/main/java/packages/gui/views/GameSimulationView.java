package packages.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import packages.models.EnemyModel;
import packages.models.HeroModel;
import packages.utils.JFrameHelper;;

public class GameSimulationView extends JFrame
{
    private EnemyModel _enemy;
    private HeroModel _hero;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel heroPanel;
    private JPanel simulationPanel;
    private JTextArea _txtASimulation;
    private JLabel _simulationLabel;    
    private JPanel villanPanel;
    private Image heroImage;
    private JLabel lblHeroImage;
    private Image enemyImage;
    private JLabel lblEnemyImage;
    private String _simulationText = null;
    public GameSimulationView()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Game Simulation");
        this.setSize(1060, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
            
        this.init();
        //this.setLayout(null);
    }

    public void init()
    {
        this._txtASimulation = new JTextArea();//null, 10, 10);
        JScrollPane scroll = new JScrollPane(_txtASimulation);
        this.mainPanel = new JPanel();
        this.simulationPanel = new JPanel();        
        this.mainPanel.setLayout(null);
        this.heroPanel = new JPanel();
        this.bottomPanel = new JPanel();
        this.villanPanel = new JPanel();
        String test = "This is an editable JTextArea. " +
        "\nA text area is a \"plain\" text component, " +
        "\nwhich means that although it can display text " +
        "\nin any font, all of the text is in the same font.";

        this.simulationPanel.setBackground(new Color(255, 0, 0));   
        this.bottomPanel.setBackground(new Color(255, 0, 0));   
        //this.simulationPanel.setLayout(null);     
        this.heroPanel.setBackground(new Color(0, 0, 0));
        this.villanPanel.setBackground(new Color(204, 204, 204));

        this.bottomPanel.setBounds(0, 0, this.getWidth(), this.getHeight() - 250);
        this.heroPanel.setBounds(0, 0, this.getHeight(), this.getHeight());
        this.villanPanel.setBounds(this.getWidth() - this.heroPanel.getWidth(), 0, this.getWidth() - this.heroPanel.getHeight(), this.heroPanel.getHeight());        
        this.simulationPanel.setBounds(this.heroPanel.getWidth(), 0, (this.getWidth() - (this.heroPanel.getHeight() * 2)), this.getHeight());

        this._txtASimulation.setText(test);
        this.simulationPanel.add(this._txtASimulation);        
        
        this.mainPanel.add( this.heroPanel, BorderLayout.WEST );        
        this.mainPanel.add( this.simulationPanel, BorderLayout.CENTER );
        this.mainPanel.add( this.villanPanel, BorderLayout.EAST );

        
        // JLabel lblImg = JFrameHelper.getLabelImage(_enemy.getIcon());
        // if (lblImg != null){
        //     this.villanPanel.add(lblImg);
        // }
        this.add(this.mainPanel);
    }

    // private boolean setImage(String imagePath){
    //     try{
    //         ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(imagePath)));
    //         //ImageIcon imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource("packages/images/default-image.png"));
    //         Image image = imageIcon.getImage();
    //         this.heroImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    //         this.lblHeroImage.setIcon(new ImageIcon(this.heroImage));
    //         return (true);
    //     }catch(Exception exc){
    //         System.err.println("Error Setting Image: " + exc.getMessage());
    //     }
    //     return (false);
    // }

    public      void setSimulationText(String simulationText)
    {
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
        this._txtASimulation.setText(simulationText);
    }
}