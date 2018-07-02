package packages.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameSimulationView extends JFrame
{
    private JTextArea _txtASimulation;
    private JButton _btnStart;
    private JButton _btnSkip;

    public GameSimulationView()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Game Simulation");
        this.setSize(1060, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
            
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

        simulationPanel.setBackground(new Color(255, 0, 0));   
        bottomPanel.setBackground(new Color(255, 100, 100));   
        heroPanel.setBackground(new Color(0, 0, 0));
        villanPanel.setBackground(new Color(204, 204, 204));

        
        heroPanel.setBounds(0, 0, this.getHeight(), this.getHeight());
        villanPanel.setBounds(this.getWidth() - heroPanel.getWidth(), 0, this.getWidth() - heroPanel.getHeight(), heroPanel.getHeight());        
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

        
        // JLabel lblImg = JFrameHelper.getLabelImage(_enemy.getIcon());
        // if (lblImg != null){
        //     this.villanPanel.add(lblImg);
        // }
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
}