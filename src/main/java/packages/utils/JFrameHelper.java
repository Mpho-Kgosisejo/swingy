package packages.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameHelper{
    public static void ShowErrorDialog(JFrame jFrame, String message){
        JOptionPane.showMessageDialog(jFrame, message,"Warning!", JOptionPane.WARNING_MESSAGE);
    }

    public static Boolean ShowConfirmDialog(JFrame jFrame, String title, String message){
        int response = JOptionPane.showConfirmDialog(jFrame, message, title, JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION){
            return (true);
        }
        return (false);
    }
}