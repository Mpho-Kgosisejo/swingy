package packages.gui.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import packages.console.controller.Coordinates;
import packages.gui.views.GameView;
import packages.models.HeroModel;

public class GameController{
    private GameView view;
    private HeroModel hero;

    public GameController(GameView view){
        this.view = view;
        this.hero = this.view.getHero();
        this.view.setKeyListener(new TheKeyListener());
    }

    private class TheKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {
            moveHero(e.getKeyCode());
		}

		public void keyReleased(KeyEvent e) {}
    }

    private void moveHero(int code){
        int x = hero.getCoordinates().getX();
        int y = hero.getCoordinates().getY();
        int oldX = x;
        int oldY = y;

        switch (code){
            case 38:
                // Up
                y--;
            break;
            case 40:
                // Down
                y++;
            break;
            case 37:
                // Left
                x--;
            break;
            case 39:
                // Right
                x++;
            break;
        }
        x = Coordinates.getPositionMax(x, (this.view.getMapSize() - 1));
        y = Coordinates.getPositionMax(y, (this.view.getMapSize() - 1));
        hero.setCoordinates(new Coordinates(x, y));
        //if (oldX != x && oldY != y){
            this.view.drawMap();
        //}
    }
}