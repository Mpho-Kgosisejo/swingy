package packages.models;

import java.util.List;

public class SelectHeroModel{
    private List<HeroModel> heroList;

    public SelectHeroModel(List<HeroModel> heroList){
        this.heroList = heroList;
    }

    public HeroModel getHero(int index){
        if (index >= 0 && index < this.heroList.size()){
            return (this.heroList.get(index));
        }
        return (null);
    }

    public List<HeroModel> getHeroList(){
        return (this.heroList);
    }

    public String getHeroInfo(HeroModel hero){
        String info = "Name: " + hero.getName() + "\n" +
            "Type: " + hero.getType() + "\n" +
            "Level: " + hero.getLevel() + "\n" +
            "X-Points: " + hero.getXPoints() + "\n" +
            "Attack: " + hero.getAttack() + "\n" +
            "Defense: " + hero.getDefense() + "\n" +
            "Hit Points: " + hero.getHitPoints() + "\n" +            
            "Weapon: " + hero.getWeapon() + "\n" +
            "Armor: " + hero.getArmor() + "\n" + 
            "Helm: " + hero.getHelm();  
        return (info);
    }
}