package packages.gui.controllers;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packages.gui.views.GameSimulationView;
import packages.models.EnemyModel;
import packages.models.GameSimulationModel;
import packages.models.HeroModel;

public class GameSimulationController
{
    private GameSimulationView _view;
    private GameSimulationModel _model;

    public GameSimulationController(GameSimulationView view, GameSimulationModel gameSimulationModel)
    {
        this._view = view;
        this._model = gameSimulationModel;

        this._view.startBtnListener(new StartBtnListener());
        this._view.skipBtnListener(new SkipBtnListener());
    }

    public void startSimulation(){
        System.out.println("Hero: "+ this._model.getHeroModel().getHitPoints() +"HP , Enemy: " + this._model.getEnemyModel().getHitPoints() + "HP");

        try {
            while(this._model.nextFight()){
                this._view.setSimulationText(this._model.getSimulationOutput() + "\n");
                System.out.println(">> " + this._model.getSimulationOutput());
            }
            this._view.setSimulationText("Game ended...");
            System.out.println("Game ended...");
            System.out.println("Hero: "+ this._model.getHeroModel().getHitPoints() +"HP , Enemy: " + this._model.getEnemyModel().getHitPoints() + "HP");
        } catch (Exception e) {
            System.out.println("Error @ GameSimulation(): " + e.getMessage());
        }
    }

    private class StartBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            startSimulation();
		}
    }

    private class SkipBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Skip button clicked!");
		}
    }
}