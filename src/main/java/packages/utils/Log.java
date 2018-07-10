package packages.utils;

public class Log
{
    public static void out(String message)
    {
        System.err.println("Log() => " + message);
    }
    
    public static void out(Object obj, String message)
    {
        System.err.println("Log()["+ obj.toString() +"] => " + message);
    }
}