package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packages.gui.views.CreateHeroView;
import packages.gui.views.SelectHeroView;

public class SelectHeroController{
    private SelectHeroView view;

    public SelectHeroController(SelectHeroView view){
        this.view = view;

        this.view.navigateToCreateHeroListener(new NavigateToCreateHeroListener());
        this.view.loadHeroListener(new LoadHeroListener());
    }

    class NavigateToCreateHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            new CreateHeroView().setVisible(true);
            view.dispose();
		}
    }

    class LoadHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            System.out.println("LoadHeroListener();");
		}
    }
}