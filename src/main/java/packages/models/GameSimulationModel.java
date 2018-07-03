package packages.models;

import java.util.Random;

public class GameSimulationModel{
    private HeroModel hero;
    private EnemyModel enemy;
    private String simulationOutput = "";
    private int simulationCount = 0;
    private int simulationMiliSecs = 1500;

    public GameSimulationModel(HeroModel hero, EnemyModel enemy){
        this.hero = hero;
        this.enemy = enemy;
    }

    public Boolean nextFight() throws InterruptedException{
        if (this.isHeroAlive(this.hero) && this.isHeroAlive(this.enemy)){            
            simulationCount++;
            Random rand = new Random();
            int rn = rand.nextInt(2);
            if (rn == 0)
                this.enemy.setHitPoints((this.enemy.getHitPoints() - 1));
            else
                this.hero.setHitPoints((this.hero.getHitPoints() - 1));
            simulationOutput = "* simulation " + simulationCount + "*";
            Thread.sleep(this.simulationMiliSecs);
            return (true);
        }
        return (false);
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