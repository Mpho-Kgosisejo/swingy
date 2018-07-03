package packages.console.view;

import packages.enums.ArmorType;
import packages.enums.CharacterType;
import packages.enums.HelmType;
import packages.enums.WeaponType;
import packages.models.*;
import packages.utils.EnemyFactory;
import packages.utils.Formulas;
import packages.utils.Menus;
import packages.utils.WriteFile;

import static packages.utils.Colours.*;
import packages.console.controller.*;

import java.io.*;
import java.util.*;

public class Maps
{
    public int map[][];
    private int mapSize;

    private static List<EnemyModel> enemyList;

    public void init(HeroModel hero) {
        
        this.mapSize = Formulas.sizeMap(hero.getLevel());
        hero.setCoordinates(new Coordinates((this.mapSize / 2), (this.mapSize / 2)));
        enemyList = EnemyFactory.getEnemyList(hero);
    }

    public void move(Scanner scan, HeroModel hero, int MapSize) {
        System.out.println("map: " + MapSize + "\n" + hero.getCoordinates().getX());
        if (hero.getCoordinates().getX() == MapSize - 1 || hero.getCoordinates().getY() == MapSize - 1 || hero.getCoordinates().getY() == 0 || hero.getCoordinates().getX() == 0)
        {
            System.out.println(ANSI_YELLOW +  "\n>>>>>> You won the game! <<<<<<\n" + ANSI_RESET);
            hero.setXPoints(hero.getXPoints() + 100);;
            WriteFile.findAndUpdate(ConsoleView.heroList, hero);
            ConsoleView.start();//why should it start again?
        }
        for (EnemyModel enemyLoop: enemyList) {
            if (enemyLoop.getCoordinates().Isequals(hero.getCoordinates())){
                //heroEnemyCoordinatesMatch = new Coordinates(enemyLoop.getCoordinates().getX(), enemyLoop.getCoordinates().getY());
                Menus.SimulationChoice();
            }
        }

        while (scan.hasNextLine())
        {
            if (scan.hasNextInt())
            {
                int n = scan.nextInt();
                switch (n) {
                    case 1:
                        hero.getCoordinates().advance(1);
                        break;
                    case 2:
                        hero.getCoordinates().advance(2);
                        break;
                    case 3:
                        hero.getCoordinates().advance(3);
                        break;
                    case 4:
                        hero.getCoordinates().advance(4);
                        break;
                    case 0:
                        ConsoleView.start();
                        break;
                    default:
                        break;
                }
                drawMap(hero);
            }
            else
            {
                System.out.println(ANSI_RED + "INPUT MUST BE NUMERIC!!!REDIRECTING YOU TO THE START MENU\n" + ANSI_RESET);
                ConsoleView.start();
            }
        }
    }

    public void drawMap(HeroModel hero)
    {
        System.out.println();
        for (int x = 0; x < this.mapSize; x++) {
            for (int y = 0; y < this.mapSize; y++) {
                Coordinates loopCoordinates = new Coordinates(x, y);
                boolean didShow = false;
                if (loopCoordinates.Isequals(hero.getCoordinates()))
                {
                    System.out.print(ANSI_GREEN + "0 " + ANSI_RESET);
                }
                else 
                {
                    for (EnemyModel enemyModel : enemyList)
                    {
                        if (loopCoordinates.Isequals(enemyModel.getCoordinates()))
                        {
                            System.out.print(ANSI_PURPLE + "E " + ANSI_RESET);
                            didShow = true;
                        }
                        /*else if (hero.getCoordinates().Isequals(enemyModel.getCoordinates()))
                        {
                            Menus.SimulationChoice();
                            //FightOrRun(hero, enemyModel);
                        }*/
                    }
                    if (!didShow)
                    {
                        System.out.print("* ");
                    }
                }

            }
            System.out.println(); 
        }

        Menus.printMovementMenu();
        Scanner reader = new Scanner(System.in);
        move(reader, hero, mapSize);


    }
}