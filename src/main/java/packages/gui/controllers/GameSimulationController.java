package packages.gui.controllers;

import java.awt.List;

import packages.gui.views.GameSimulationView;
import packages.models.EnemyModel;
import packages.models.HeroModel;

public class GameSimulationController
{
    private EnemyModel _enemy;
    private HeroModel _hero;
    private GameSimulationView _view;

    public GameSimulationController(GameSimulationView view, EnemyModel enemy, HeroModel hero)
    {
        this._enemy = enemy;
        this._hero = hero;
        this._view = view;
    }

    
}