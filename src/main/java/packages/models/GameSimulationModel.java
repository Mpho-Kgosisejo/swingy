package packages.models;

public class GameSimulationModel{
    private HeroModel hero;
    private EnemyModel enemy;

    public GameSimulationModel(HeroModel hero, EnemyModel enemy){
        this.hero = hero;
        this.enemy = enemy;
    }
}