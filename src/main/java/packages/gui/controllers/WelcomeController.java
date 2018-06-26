package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packages.gui.views.WelcomeView;

public class WelcomeController{
    private WelcomeView view;

    public WelcomeController(WelcomeView view){
        this.view = view;

        this.view.navigateToSelectHeroListener(new NavigateToSelectHeroListener());
        this.view.navigateToCreateHeroListener(new NavigateToCreateHeroListener());
    }

    class NavigateToSelectHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            System.out.println("navigateToSelectHeroListener() clicked! 1");
		}
    }

    class NavigateToCreateHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            System.out.println("navigateToCreateHeroListener() clicked! 2");
		}
    }
}