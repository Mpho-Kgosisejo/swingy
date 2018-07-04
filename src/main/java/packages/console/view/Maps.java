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

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Maps
{
    private Random rand = new Random();
    private int mapSize;

    private static List<EnemyModel> enemyList;
    private static EnemyModel enemy;

    public void init(HeroModel hero) {
        
        this.mapSize = Formulas.sizeMap(hero.getLevel());
        hero.setCoordinates(new Coordinates((this.mapSize / 2), (this.mapSize / 2)));
        enemyList = EnemyFactory.getEnemyList(hero);
    }

    private void winGame(HeroModel hero){
        System.out.println(ANSI_YELLOW +  "\n>>>>>> You won the game! <<<<<<\n" + ANSI_RESET);
        hero.setLevel(hero.getLevel() + 1);
        hero.setXPoints(Formulas.getXPoints(hero.getLevel()));

        WriteFile.findAndUpdate(ConsoleView.heroList, hero);
    }


    public void move(Scanner scan, HeroModel hero, int MapSize) {
        System.out.println("map: " + MapSize + "\n" + hero.getCoordinates().getX());
        if (hero.getCoordinates().getX() == MapSize || hero.getCoordinates().getY() == MapSize || hero.getCoordinates().getY() == - 1 || hero.getCoordinates().getX() == - 1)
        {
            winGame(hero);
            ConsoleView.start();
        }
        for (EnemyModel enemyLoop: enemyList) {
            if (enemyLoop.getCoordinates().Isequals(hero.getCoordinates())){
                //heroEnemyCoordinatesMatch = new Coordinates(enemyLoop.getCoordinates().getX(), enemyLoop.getCoordinates().getY());
                Menus.SimulationChoice();
                FightOrRun(hero, enemyLoop);
            }
        }

        while (scan.hasNextLine())
        {
            if (scan.hasNextInt())
            {
                int n = scan.nextInt();
                switch (n)
                {
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
                System.out.println(ANSI_RED + "\nInput must be numeric please select another option" + ANSI_RESET);
                drawMap(hero);
            }
            
        }
    }

    public void drawMap(HeroModel hero)
    {
        boolean isSamePosition = false;
        System.out.println();
        for (int x = 0; x < this.mapSize; x++) {
            for (int y = 0; y < this.mapSize; y++) {
                Coordinates loopCoordinates = new Coordinates(x, y);
                boolean didShow = false;
                if (loopCoordinates.Isequals(hero.getCoordinates()))
                    System.out.print(ANSI_GREEN + "0 " + ANSI_RESET);
                else 
                {
                    for (EnemyModel enemyModel : enemyList)
                    {
                        if (loopCoordinates.Isequals(enemyModel.getCoordinates()))
                        {
                            System.out.print(ANSI_PURPLE + "E " + ANSI_RESET);
                            didShow = true;
                        }
                        else if (hero.getCoordinates().Isequals(enemyModel.getCoordinates()))
                        {
                            isSamePosition = true;
                            enemy = enemyModel;
                        }    
                    }
                    if (!didShow)
                    {
                        System.out.print("* ");
                    }
                }

            }
            System.out.println(); 
        }
        //if (isSamePosition == true)
            //FightOrRun(hero, enemy);
        Menus.printMovementMenu();
        Scanner reader = new Scanner(System.in);
        move(reader, hero, mapSize);
    }

    private void FightOrRun(HeroModel hero, EnemyModel enemyModel) 
    {
        System.out.println("bleh bleh bleh: " + enemy.getHitPoints());
        if (enemy.getHitPoints() > 0)
        {
            //Menus.SimulationChoice();
            Scanner _reader = new Scanner(System.in);
        
            System.out.println(ANSI_CYAN + hero.getName().toUpperCase() + ANSI_RESET  + " VS " + enemy.getName().toUpperCase());
            while (_reader.hasNextLine())
            {
                if (_reader.hasNextInt())
                {
                    int n = _reader.nextInt();
                    switch (n)
                    {
                        case 1:
                            int rn = rand.nextInt(2);
                            if (rn == 0)
                                System.out.println("You ran away");
                            else if (rn == 1)
                            {
                                System.out.println("Luck is not on your side, you still have to fight the enemy");
                                Fight(hero, enemyModel);
                            }
                            break;
                        case 2:
                            Fight(hero, enemyModel);
                            break;
                        default:
                            break;
                    }
                }
                else
                {
                    System.out.println(ANSI_RED + "\nInput must be numeric please select another option" + ANSI_RESET);
                    FightOrRun(hero, enemyModel);
                }
            } 
        }   
    }

    private void Fight(HeroModel hero, EnemyModel enemy) 
    {
        try
        {
            GameSimulationModel gsm = new GameSimulationModel(hero, enemy);
            while (gsm.nextFight())
            {
                System.out.println(gsm.getSimulationOutput());
                System.out.println("hero: " + hero.getHitPoints() + " enemy: " + enemy.getHitPoints());
            }
            if (!gsm.isHeroAlive(gsm.getHeroModel()) && !gsm.isHeroAlive(gsm.getEnemyModel())){
                System.out.println("No Winner No winner...");
            }else{
                String mssg = "";

                if (gsm.isHeroAlive(gsm.getHeroModel())){
                    mssg = gsm.getHeroModel().getName() + " won the fight";
                    System.out.println(ANSI_CYAN + "Fight Won: " + ANSI_RESET +  mssg);
                    enemyList.remove(enemy);
                    drawMap(hero);
                }else{
                    mssg = gsm.getEnemyModel().getName() + " won the fight";
                    System.out.println(ANSI_CYAN + "Fight Lost: " + ANSI_RESET +  mssg);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(ANSI_RED + "Something went wrong." + ANSI_RESET);
        }
        
    }
    
}