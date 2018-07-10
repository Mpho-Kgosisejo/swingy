package packages.app_start;

import packages.exceptions.ArgumentException;

public class RouteConfig
{
    public static void init(String args) throws ArgumentException
    {
        if (args.equalsIgnoreCase("console"))
        {
            System.out.println("Console");
        }
        else if (args.equalsIgnoreCase("gui"))
        {
            System.out.println("Graphics");
        }
        else
        {
            throw new ArgumentException("Argument not valid exception:");
        }
    }
}