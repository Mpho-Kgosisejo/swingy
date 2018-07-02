package packages.gui.controllers;

import java.awt.List;

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

        System.out.println("Hero: "+ this._model.getHeroModel().getHitPoints() +"HP , Enemy: " + this._model.getEnemyModel().getHitPoints() + "HP");
        this.startSimulation();
    }

    private void startSimulation(){
        try {
            while(this._model.nextFight()){
                this._view.setSimulationText(this._model.getSimulationOutput());
                System.out.println(">> " + this._model.getSimulationOutput());
            }
            this._view.setSimulationText("Game ended...");
            System.out.println("Game ended...");
        } catch (Exception e) {
            
        }
    }
}