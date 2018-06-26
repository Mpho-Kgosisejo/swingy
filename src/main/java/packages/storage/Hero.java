package packages.storage;

import packages.storage.HeroType;
import java.io.*;


public class Hero
{
    public static void newHero(String name, String type, int level, int xPoints, String weapon, String armor)
    {
        String storeType = type.trim().toLowerCase();
        String temp = "";

        switch(storeType)
        {
            case "warrior":
                temp = "warrior";
                break;
            case "hunter":
                temp = "hunter";
                break;
            case "elf":
                temp = "elf";
                break;
            case "knight":
                temp = "knight";
                break;
            case "villager":
                temp = "villager";
                break;
            default:
                break;
        }
    }
}