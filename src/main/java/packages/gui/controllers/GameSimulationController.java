package packages.gui.controllers;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import packages.gui.views.GameSimulationView;
import packages.gui.views.GameView;
import packages.models.EnemyModel;
import packages.models.GameSimulationModel;
import packages.models.HeroModel;
import packages.utils.JFrameHelper;

public class GameSimulationController extends JFrameHelper
{
    private GameView            _gameView;
    private GameSimulationView  _view;
    private GameSimulationModel _model;

    public GameSimulationController(GameSimulationView view, GameSimulationModel gameSimulationModel, GameView gameView)
    {
        this._view = view;
        this._model = gameSimulationModel;
        this._gameView = gameView;

        this._view.startBtnListener(new StartBtnListener());
        this._view.skipBtnListener(new SkipBtnListener());

        this.startSimulation();
    }
    
    public void startSimulation(){
        new Thread(new StartSimulation()).start();
    }

    private class StartBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("StartBtnListener clicked!");
		}
    }

    private class SkipBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Skip button clicked!");
		}
    }

    private class StartSimulation implements Runnable{
		public void run() {
			try {
                _view.setText("\n" + "\t" +
                 _model.getHeroModel().getName() +
                " \n" +
                " \n" +
                "\t   ##     ##    ######       \n" + 
                "\t   ##     ##   ##    ##      \n" +
                "\t   ##     ##   ##            \n" +
                "\t   ##     ##    ######       \n" +
                "\t    ##   ##             ##      \n" +
                "\t     ## ##     ##    ##      \n" +
                "\t      ###       ######       \n" +
                " \n" + "\t" +
                _model.getEnemyModel().getName()); 
                Thread.sleep(2000);
                _view.setText("");
                while(_model.nextFight()){
                    _view.setSimulationText(_model.getSimulationOutput() + "\n");
                    System.out.println(">> " + _model.getSimulationOutput());
                }
                _view.setSimulationText("Game ended...");

                if (!_model.isHeroAlive(_model.getHeroModel()) && !_model.isHeroAlive(_model.getEnemyModel())){
                    ShowInfoDialog(_view, "No Winner","No winner...");
                }else{
                    String mssg = "";

                    if (_model.isHeroAlive(_model.getHeroModel())){
                        mssg = _model.getHeroModel().getName() + " won the fight";
                        ShowInfoDialog(_view, "Fight Won", mssg);
                    }else{
                        mssg = _model.getEnemyModel().getName() + " won the fight";
                        ShowInfoDialog(_view, "Fight Lost", mssg);
                    }
                }
                _view.dispose();
                _gameView.drawMap();
                _gameView.setVisible(true);
            } catch (Exception e) {
                System.out.println("Error @ GameSimulation(): " + e.getMessage());
            }
		}
    }
}