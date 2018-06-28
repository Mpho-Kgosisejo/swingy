package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
      List<HeroModel> heroList = null;

      try {
        heroList = readFile.simulateFile("test.txt");
      } catch (Exception exc) {
        exc.printStackTrace();
      }

      new SelectHeroView(heroList).setVisible(true);
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