package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import packages.gui.views.CreateHeroView;
import packages.gui.views.SelectHeroView;
import packages.gui.views.WelcomeView;

public class WelcomeController{
  private WelcomeView view;

  public WelcomeController(WelcomeView view){
    this.view = view;
    this.view.setVisible(true);

    this.view.navigateToSelectHeroListener(new NavigateToSelectHeroListener());
    this.view.navigateToCreateHeroListener(new NavigateToCreateHeroListener());
  }

  class NavigateToSelectHeroListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      new SelectHeroController(new SelectHeroView());
      view.dispose();
    }
  }

  class NavigateToCreateHeroListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      new CreateHeroController(new CreateHeroView());
      view.dispose();
    }
  }
}