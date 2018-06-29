package packages.gui.controllers;

import packages.gui.views.GameView;
import packages.models.HeroModel;

public class GameController{
    private GameView view;
    private HeroModel hero;

    public GameController(GameView view){
        this.view = view;
        this.hero = this.view.getHero();
    }
}