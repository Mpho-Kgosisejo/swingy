package packages.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import packages.config.Config;
import packages.content.Colors;
import packages.enums.AppDisplay;

public class SwingyIO{
    private static JFrame _jFrame = null;

    public SwingyIO(JFrame jFrame){
        _jFrame = jFrame;
    }

    public static void IntegerOutput(int number)
    {
        System.out.print(number);
    }

    public static void ConsoleOutput(String message)
    {
        System.out.print(message);
    }

    public static void ConsoleOutput(String message, String colour)
    {
        ConsoleOutput(colour + message + Colors.ANSI_RESET);
    }

    public static void Output(String message)
    {
        if (Config.AppDisplayMode == AppDisplay.console)
        {
            ConsoleOutput(message);
        }
        else if (Config.AppDisplayMode == AppDisplay.gui)
        {
            JOptionPane.showMessageDialog(_jFrame, message);
        }
    }

    public static void Output(String title, String message)
    {
        if (Config.AppDisplayMode == AppDisplay.console)
        {
            ConsoleOutput("[" + title + "] => " + message);
        }
        else if (Config.AppDisplayMode == AppDisplay.gui)
        {
            JOptionPane.showMessageDialog(_jFrame, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void OutputError(String title, String message){
        if (Config.AppDisplayMode == AppDisplay.console)
        {
            ConsoleOutput("[" + title + "] => " + message, Colors.ANSI_RED);
        }
        else if (Config.AppDisplayMode == AppDisplay.gui)
        {
            JOptionPane.showMessageDialog(_jFrame, message, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void OutputWarning(String title, String message){
        if (Config.AppDisplayMode == AppDisplay.console)
        {
            ConsoleOutput("[" + title + "] => " + message, Colors.ANSI_YELLOW);
        }
        else if (Config.AppDisplayMode == AppDisplay.gui)
        {
            JOptionPane.showMessageDialog(_jFrame, message, title, JOptionPane.WARNING_MESSAGE);
        }
    }
}