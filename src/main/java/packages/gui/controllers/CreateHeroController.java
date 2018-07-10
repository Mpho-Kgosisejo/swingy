 package packages.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import packages.config.Config;
import packages.gui.views.CreateHeroView;
import packages.gui.views.SelectHeroView;
import packages.models.CreateHeroModel;
import packages.providers.DataProvider;
import packages.utils.Messages;
import packages.utils.SwingyIO;
import packages.utils.WriteFile;

public class CreateHeroController{
    private CreateHeroView _view;
    private CreateHeroModel _model;

    public CreateHeroController(CreateHeroView view){
        this._view = view;
        this._view.setVisible(true);

        this._view.cancelListener(new CancelListener());
        this._view.selectHeroImageListener(new SelectHeroImageListener());
        this._view.createHeroListener(new CreateHeroListener());

        this._model = new CreateHeroModel();
    }

    private void navigateToSelectHero(){
        new SelectHeroController(new SelectHeroView());
        _view.dispose();
    }

    class CancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            navigateToSelectHero();
		}
    }

    class SelectHeroImageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();

            if (fileChooser.showOpenDialog(_view) == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                
                _model.setHeroImagePath(filePath);
                _view.setHeroImagePath(filePath);
            }
		}
    }

    class CreateHeroListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            String errorMessage = _model.setHero(_view.getHeroName(), _view.getCharacterType());

            if (_model.getHero() != null)
            {
                DataProvider db = new DataProvider(Config.DATA_PROVIDER);
                db.insertHero(_model.getHero());
                //WriteFile.writeToFile(_model.getHero());
                navigateToSelectHero();
            }
            else
            {
                if (errorMessage != null)
                    SwingyIO.OutputWarning(_view.getTitle() + " - Warning", errorMessage);
                else
                    SwingyIO.OutputError(Messages.UnknownError, Messages.UnknownErrorOccurred);
            }
		}
    }


}