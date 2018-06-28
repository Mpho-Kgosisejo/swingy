package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import packages.gui.views.CreateHeroView;
import packages.gui.views.SelectHeroView;
import packages.utils.JFrameHelper;

public class SelectHeroController extends JFrameHelper{
    private SelectHeroView view;

    public SelectHeroController(SelectHeroView view){
        this.view = view;

        this.view.navigateToCreateHeroListener(new NavigateToCreateHeroListener());
        this.view.loadHeroListener(new LoadHeroListener());
        this.view.heroClickListener(new HeroClickListener());
        this.view.selectHeroListener(new SelectHeroListener());
    }

    public void doActionSelectHero(int index){
        view.setSelectedHero();
    }

    class NavigateToCreateHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            new CreateHeroView().setVisible(true);
            view.dispose();
		}
    }

    class LoadHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            if (view.getMouseClickIndex() >= 0){
                doActionSelectHero(view.getMouseClickIndex());
            }else{
                ShowErrorDialog(view, "Select an item on te list before clicking \"Load Hero\"");
            }
		}
    }

    class SelectHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            System.out.println("setSelectedHero()");
		}
    }

    class HeroClickListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
            view.setMouseClickIndex(e.getPoint());

            if (e.getClickCount() == 2){
                doActionSelectHero(view.getMouseClickIndex());
            }
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
    }
}