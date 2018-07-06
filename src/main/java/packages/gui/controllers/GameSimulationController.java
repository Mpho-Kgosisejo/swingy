package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packages.gui.views.GameSimulationView;
import packages.gui.views.GameView;
import packages.models.GameSimulationModel;
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

        this._view._btnIncreaseSpeedListener(new BtnIncreaseSpeedListener());
        this._view.skipBtnListener(new SkipBtnListener());

        this.startSimulation();
    }
    
    public void startSimulation(){
        new Thread(new StartSimulation()).start();
    }

    private class BtnIncreaseSpeedListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            int speed = _model.getSimulationMiliSecs();
            if (speed > 0){
                speed -= 100;
            }else{
                speed = 0;
            }            
            _model.setSimulationMiliSecs(speed);
            _view.setBtnIncreaseSpeedText("Speed ("+ _model.getSimulationMiliSecs() +"/1500)");
		}
    }

    private class SkipBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            _model.setSimulationMiliSecs(0);
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
                    _view.setWinTitle(_model.getVSMessage());
                }
                _view.setSimulationText("Game ended...");
                GameSimulationModel.resetHero(_model.getHeroModel());

                if (!_model.isHeroAlive(_model.getHeroModel()) && !_model.isHeroAlive(_model.getEnemyModel())){
                    ShowInfoDialog(_view, "No Winner","No winner...");
                }else{
                    String mssg = "";

                    if (_model.isHeroAlive(_model.getHeroModel())){
                        mssg = _model.getHeroModel().getName() + " won the fight";
                        GameSimulationModel.dropArtifact(_model.getHeroModel(), _model.getEnemyModel());
                        ShowInfoDialog(_view, "Fight Won", mssg);
                        _gameView.drawMap();
                        _gameView.setVisible(true);
                    }else{
                        mssg = "Lost the Fight againt " + _model.getEnemyModel().getName();
                        ShowInfoDialog(_view, "Fight Lost", mssg);
                        GameSimulationModel.resetHero(_model.getHeroModel());
                        _gameView.disposeWindow();
                        _gameView.dispose();
                    }
                }
                _view.dispose();
            } catch (Exception e) {
                System.out.println("Error @ GameSimulation(): " + e.getMessage());
            }
		}
    }
}