package packages.gui.views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import packages.models.GameSimulationModel;
import packages.utils.JFrameHelper;

public class GameSimulationView extends JFrame
{
    private JTextArea _txtASimulation;
    private JButton _btnStart;
    private JButton _btnSkip;
    private JLabel _lblHero;
    private JLabel _lblVillan;
    private GameSimulationModel _model;

    public GameSimulationView(GameSimulationModel model)
    {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Game Simulation");
        this.setSize(1060, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this._model = model;
            
        this.init();
    }

    public void init()
    {
        this._txtASimulation = new JTextArea();
        JPanel mainPanel = new JPanel();
        JPanel simulationPanel = new JPanel();        
        simulationPanel.setLayout(null);
        mainPanel.setLayout(null);
        JPanel heroPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel villanPanel = new JPanel();
        this._btnStart = new JButton("Start");
        this._btnSkip = new JButton("Skip");
        this._txtASimulation.setEditable(false);

        this._lblHero = JFrameHelper.getLabelImage(this._model.getHeroModel().getIcon(), 260);
        this._lblVillan = JFrameHelper.getLabelImage(this._model.getEnemyModel().getIcon(), 260);
        heroPanel.add(this._lblHero);
        villanPanel.add(this._lblVillan);

        heroPanel.setBounds(0, 0, this.getHeight(), this.getHeight());
        villanPanel.setBounds(this.getWidth() - heroPanel.getWidth(), 0, heroPanel.getHeight(), heroPanel.getHeight());        
        simulationPanel.setBounds(heroPanel.getWidth(), 0, (this.getWidth() - (heroPanel.getHeight() * 2)), this.getHeight() -60);
        bottomPanel.setBounds(heroPanel.getWidth(), simulationPanel.getHeight(), simulationPanel.getWidth(), 60);
        this._txtASimulation.setBounds(0, 0, simulationPanel.getWidth(), simulationPanel.getHeight());
        
        bottomPanel.add(this._btnStart);
        bottomPanel.add(this._btnSkip);
        simulationPanel.add(this._txtASimulation);        
        
        mainPanel.add( heroPanel, BorderLayout.WEST );        
        mainPanel.add( simulationPanel, BorderLayout.CENTER );
        mainPanel.add( bottomPanel, BorderLayout.CENTER );
        mainPanel.add( villanPanel, BorderLayout.EAST );

        this.add(mainPanel);
    }

    public void startBtnListener(ActionListener listener)
    {
        this._btnStart.addActionListener(listener);
    }

    public void skipBtnListener(ActionListener listener)
    {
        this._btnSkip.addActionListener(listener);
    }

    public      void setSimulationText(String simulationText)
    {
        this._txtASimulation.append(simulationText);
    }

    public void setText(String message)
    {
        this._txtASimulation.setText(message);
    }
}