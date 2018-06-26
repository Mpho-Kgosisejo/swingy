package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import packages.gui.views.CreateHeroView;
import packages.gui.views.SelectHeroView;
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
        DefaultListModel<String> tmpHeroList = new DefaultListModel<String>();
        tmpHeroList.addElement("Hero 1");
        tmpHeroList.addElement("Hero 2");
        tmpHeroList.addElement("Hero 3");
        tmpHeroList.addElement("Hero 4");
        tmpHeroList.addElement("Hero 5");

        new SelectHeroView(tmpHeroList).setVisible(true);
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