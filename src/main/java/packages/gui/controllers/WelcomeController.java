package packages.gui.controllers;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import packages.gui.views.CreateHeroView;
import packages.gui.views.SelectHeroView;
import packages.gui.views.WelcomeView;
import packages.models.HeroModel;
import packages.utils.readFile;

public class WelcomeController{
    private WelcomeView view;

    public WelcomeController(WelcomeView view){
      this.view = view;

      this.view.navigateToSelectHeroListener(new NavigateToSelectHeroListener());
      this.view.navigateToCreateHeroListener(new NavigateToCreateHeroListener());
    }

    class NavigateToSelectHeroListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
        
        DefaultListModel<String> heroNames = new DefaultListModel<String>();
        try {
          for (HeroModel hero : readFile.simulateFile("test.txt")) {
            heroNames.addElement(hero.getName());
          }
        } catch (Exception exc) {
          exc.printStackTrace();
        }

        new SelectHeroView(heroNames).setVisible(true);
        view.dispose();
      }
    }

    class NavigateToCreateHeroListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
        new CreateHeroView().setVisible(true);;
        view.dispose();
      }
    }
}