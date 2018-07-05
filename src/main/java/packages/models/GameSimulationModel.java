package packages.models;

import java.util.Random;
import packages.utils.*;

import packages.utils.Formulas;

public class GameSimulationModel{
    private HeroModel hero;
    private EnemyModel enemy;
    private String simulationOutput = "";
    private int simulationCount = 0;
    private int simulationMiliSecs = 1500;
    private static int cpyHP;

    public GameSimulationModel(HeroModel hero, EnemyModel enemy){
        this.hero = hero;
        this.enemy = enemy;
        cpyHP = this.hero.getHitPoints();
    }

    public Boolean nextFight() throws InterruptedException{
        if (this.isHeroAlive(this.hero) && this.isHeroAlive(this.enemy)){            
            simulationCount++;
            Random rand = new Random();
            int rn = rand.nextInt(2);
            int dmg = 0;
            if (rn == 0){
                dmg = (this.hero.getAttack() - this.enemy.getDefense());
                this.enemy.setHitPoints((this.enemy.getHitPoints() - dmg));
            }
            else{
                dmg = (this.enemy.getAttack() - this.hero.getDefense());
                this.hero.setHitPoints((this.hero.getHitPoints() - dmg));
            }
            simulationOutput = "* simulation " + simulationCount + "* + dmg: " + dmg;
            Thread.sleep(this.simulationMiliSecs);
            return (true);
        }
        this.hero.setHitPoints(cpyHP);
        return (false);
    }

    public static void lostGame(HeroModel hero){
        hero.setLevel(hero.getLevel() - 1);
        hero.setXPoints(Formulas.getXPoints(hero.getLevel()));
    }

    public String getVSMessage(HeroModel hero, EnemyModel enemy){
        return (hero.getName() + " (" + hero.getHitPoints() + "HP) VS " + enemy.getName() + " (" + enemy.getHitPoints() + "HP)");
    }
    
    public static void winGame(HeroModel hero){
        hero.setLevel(hero.getLevel() + 1);
        hero.setXPoints(Formulas.getXPoints(hero.getLevel()));
        //hero.setHitPoints(10);
        WriteFile.findAndUpdate(readFile.simulateFile(), hero);
    }

    public static void dropArtifact(HeroModel hero, EnemyModel enemy)
    {
        Random rand = new Random();

        switch (rand.nextInt(3))
        {
            case 0:
                    hero.setWeapon(enemy.getWeapon());
                    hero.setAttack(hero.getAttack() + 2);
                    break;
            case 1:
                    hero.setArmor(enemy.getArmor());
                    hero.setDefense(hero.getDefense() + 2);
                    break;
            case 2:
                    hero.setHelm(enemy.getHelm());
                    hero.setHitPoints(hero.getHitPoints() + 2);
                    break;
        }
        WriteFile.findAndUpdate(readFile.simulateFile(), hero);
    }

    public int getSimulationCount(){
        return (this.simulationCount);
    }

    public String getSimulationOutput(){
        return (this.simulationOutput);
    }

    public Boolean isHeroAlive(HeroModel hero){
        return (hero.getHitPoints() > 0);
    }

    public HeroModel getHeroModel(){
        return (this.hero);
    }

    public EnemyModel getEnemyModel(){
        return (this.enemy);
    }

    public void setSimulationMiliSecs(int value){
        this.simulationMiliSecs = value;
    }

    public int getSimulationMiliSecs(){
        return (this.simulationMiliSecs);
    }
}