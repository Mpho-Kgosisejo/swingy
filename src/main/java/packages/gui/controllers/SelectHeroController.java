package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import packages.gui.views.CreateHeroView;
import packages.gui.views.GameView;
import packages.gui.views.SelectHeroView;
import packages.utils.JFrameHelper;
import packages.models.HeroModel;
import packages.models.SelectHeroModel;
import packages.providers.Cache;

public class SelectHeroController extends JFrameHelper{
    private SelectHeroView view;
    private SelectHeroModel model;

    public SelectHeroController(SelectHeroView view){
        this.view = view;
        this.view.setVisible(true);
        this.model = new SelectHeroModel(Cache.HeroList);

        this.view.navigateToCreateHeroListener(new NavigateToCreateHeroListener());
        this.view.loadHeroListener(new LoadHeroListener());
        this.view.heroClickListener(new HeroClickListener());
        this.view.selectHeroListener(new SelectHeroListener());
    }

    public void doActionSelectHero(){
        HeroModel hero = this.model.getHero(view.getMouseClickIndex());

        if (hero != null)
            this.view.setHeroInfo(hero.getName(), this.model.getHeroInfo(hero), hero.getIcon());
        else
            ShowErrorDialog(view, "Select an item on te list before clicking \"Load Hero\"");
    }

    class NavigateToCreateHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            new CreateHeroController(new CreateHeroView());
            view.dispose();
		}
    }

    class LoadHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            doActionSelectHero();
		}
    }

    class SelectHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            HeroModel hero = model.getHero(view.getMouseClickIndex());

            if (hero != null){
                new GameController(new GameView(hero));
                view.dispose();
            }
            // if (GameView.FrameCount < 1)
            // {
            //     HeroModel hero = model.getHero(view.getMouseClickIndex());

            //     if (hero != null){
            //         GameView gameView = new GameView(hero);
            //         gameView.setVisible(true);
            //         new GameController(gameView);
            //         view.dispose();
            //     }
            // }
        }
    }

    class HeroClickListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
            view.setMouseClickIndex(e.getPoint());

            if (e.getClickCount() == 2){
                doActionSelectHero();
            }
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
    }
}