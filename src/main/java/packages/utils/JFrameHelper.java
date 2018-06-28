package packages.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameHelper{
    protected void ShowErrorDialog(JFrame jFrame, String message){
        JOptionPane.showMessageDialog(jFrame, message);
    }
}