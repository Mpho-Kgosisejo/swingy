package packages.console.views;

import packages.models.*;
import packages.utils.Coordinates;
import packages.utils.Formulas;
import packages.utils.Menus;
import packages.utils.SwingyIO;
import packages.factories.EnemyFactory;
import static packages.content.Colors.*;

import packages.config.Config;
import packages.console.controllers.*;

import java.util.*;

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

    public void move(Scanner scan, HeroModel hero, int MapSize) {
        if (hero.getCoordinates().getX() == MapSize || hero.getCoordinates().getY() == MapSize || hero.getCoordinates().getY() == - 1 || hero.getCoordinates().getX() == - 1)
        {
            SwingyIO.ConsoleOutput("\n_____________ YOU WON THE GAME! _____________\n", ANSI_GREEN);
            GameSimulationModel.winGame(hero);
            ConsoleView.start();
        }
        for (EnemyModel enemyLoop: enemyList) {
            if (enemyLoop.getCoordinates().Isequals(hero.getCoordinates())){
                Menus.SimulationChoice();
                FightOrRun(hero, enemyLoop);
            }
        }

        while (scan.hasNextLine())
        {
            if (scan.hasNextInt())
            {
                int n = scan.nextInt();
                GameSimulationModel.OldX = hero.getCoordinates().getX();
                GameSimulationModel.OldY = hero.getCoordinates().getY();

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
                SwingyIO.ConsoleOutput("\nInput must be numeric please select another option", ANSI_RED);
                drawMap(hero);
            }
            
        }
    }

    public void drawMap(HeroModel hero)
    {
        SwingyIO.ConsoleOutput("\n");
        SwingyIO.ConsoleOutput("YOUR COORDINATES: " + hero.getCoordinates().getX() + "," + hero.getCoordinates().getY() + "\n");
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
                            //System.out.print(ANSI_PURPLE + "E " + ANSI_RESET);
                            if (Config.IS_DEVELOPMENT)
                                System.out.print(ANSI_RED + "E " + ANSI_RESET);
                            else
                                System.out.print(ANSI_WHITE + "* " + ANSI_RESET);
                            didShow = true;
                        }
                        else if (hero.getCoordinates().Isequals(enemyModel.getCoordinates()))
                        {
                            enemy = enemyModel;
                        }    
                    }
                    if (!didShow)
                    {
                        System.out.print("* ");
                    }
                }

            }
            SwingyIO.ConsoleOutput("\n"); 
        }
        Menus.printMovementMenu();
        Scanner reader = new Scanner(System.in);
        move(reader, hero, mapSize);
    }

    private void FightOrRun(HeroModel hero, EnemyModel enemyModel) 
    {
        if (enemy.getHitPoints() > 0)
        {
            Scanner _reader = new Scanner(System.in);
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
                            {
                                SwingyIO.ConsoleOutput("\nYOU CHOSE TO RUN YOU COWARD", ANSI_GREEN);
                                hero.getCoordinates().setX(GameSimulationModel.OldX);
                                hero.getCoordinates().setY(GameSimulationModel.OldY);
                                drawMap(hero);

                            }
                            else if (rn == 1)
                            {
                                SwingyIO.ConsoleOutput("\nLuck is not on your side, you still have to fight the enemy");
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
                    SwingyIO.ConsoleOutput("\nInput must be numeric please select another option", ANSI_RED);
                    FightOrRun(hero, enemyModel);
                }
            } 
        }   
    }

    private void Fight(HeroModel hero, EnemyModel enemy) 
    {
        String artifact;
        Menus.PrintFightOpponents(hero, enemy);
        try
        {
            GameSimulationModel gsm = new GameSimulationModel(hero, enemy);
            gsm.setSimulationMiliSecs(500);
            while (gsm.nextFight())
            {
                SwingyIO.ConsoleOutput(gsm.getSimulationOutput()  + "\n");
                SwingyIO.ConsoleOutput(ANSI_GREEN +  "HERO: " + ANSI_RESET + hero.getHitPoints() + ANSI_RED + " ENEMY: " + ANSI_RESET + enemy.getHitPoints() + "\n");
            }
            if (!gsm.isHeroAlive(gsm.getHeroModel()) && !gsm.isHeroAlive(gsm.getEnemyModel())){
                SwingyIO.ConsoleOutput("No Winner No winner...");
            }else{
                String mssg = "";

                if (gsm.isHeroAlive(gsm.getHeroModel())){
                    mssg = gsm.getHeroModel().getName() + " WON THE FIGHT";
                    SwingyIO.ConsoleOutput(ANSI_CYAN + "\nFIGHT WON: " + ANSI_RESET +  mssg + "\n"); 
                    GameSimulationModel.resetHero(hero);
                    GameSimulationModel.winFight(hero, enemy);
                    artifact =  GameSimulationModel.dropArtifact(enemy);
                    SwingyIO.ConsoleOutput("\n" + ANSI_PURPLE + "THE ENEMY DROPPED A " + artifact + " DO YOU WISH TO KEEP IT?" + ANSI_RESET + "\n\n");
                    SwingyIO.ConsoleOutput("1. " + ANSI_BLUE  + "Yes" + ANSI_RESET + "\n");
                    SwingyIO.ConsoleOutput("2. " + ANSI_BLUE + "No" + ANSI_RESET + "\n");
                    PickOrNot(hero, enemy);
                    enemyList.remove(enemy);
                    drawMap(hero);
                }else{
                    mssg = gsm.getEnemyModel().getName() + " WON THE FIGHT";
                    SwingyIO.ConsoleOutput(ANSI_CYAN + "\nFIGHT LOST: " + ANSI_RESET +  mssg);
                    SwingyIO.ConsoleOutput("\n");
                    SwingyIO.ConsoleOutput("\n" + ANSI_YELLOW + "_________________ GAME OVER _________________" + ANSI_RESET);
                    SwingyIO.ConsoleOutput("\n");
                    GameSimulationModel.lostGame(hero);
                    ConsoleView.start();
                }
            }
        }
        catch (Exception e)
        {
            SwingyIO.ConsoleOutput(ANSI_RED + "\nSOMETHING WENT WRONG.\n" + ANSI_RESET);
        }
    }

    private void PickOrNot(HeroModel hero, EnemyModel enemy) 
    {
        Scanner read = new Scanner(System.in);
        int choice = 0;

        while (choice != -1)
        {
            choice = read.nextInt();
            switch (choice)
            {
                case 1:
                    GameSimulationModel.setArtifact(hero, enemy);
                    choice = -1;
                    break;
                case 2:
                    choice = -1;
                    break;
            }
        }
    }
}