package packages.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameHelper{
    public static void ShowErrorDialog(JFrame jFrame, String message){
        JOptionPane.showMessageDialog(jFrame, message);
    }
}