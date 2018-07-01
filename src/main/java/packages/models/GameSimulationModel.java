package packages.models;

import packages.gui.controllers.GameSimulationController;
import packages.gui.views.GameSimulationView;

public class GameSimulationModel{
    private HeroModel hero;
    private EnemyModel enemy;
    private String simulationOutput = "";
    private static int simulationCount;

    public GameSimulationModel(HeroModel hero, EnemyModel enemy){
        this.hero = hero;
        this.enemy = enemy;
    }

    public Boolean nextFight() throws InterruptedException{
        if (this.isHeroAlive(this.hero) && this.isHeroAlive(this.enemy)){
            simulationCount++;
            this.enemy.setHitPoints((this.enemy.getHitPoints() - 1));

            simulationOutput = "* simulation " + simulationCount + "*";
            Thread.sleep(1000);
            return (true);
        }
        return (false);
    }

    public int getSimulationCount(){
        return (this.simulationCount);
    }

    public String getSimulationOutput(){
        String ret = this.simulationOutput;
        this.simulationOutput = "";
        return (ret);
    }

    private Boolean isHeroAlive(HeroModel hero){
        return (hero.getHitPoints() > 0);
    }
}