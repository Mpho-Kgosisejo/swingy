package packages.utils;

import packages.models.HeroModel;

public class Formulas{
    public static int sizeMap(int level){
        // Formula: (level-1)*5+10-(level%2)
        int size = 0;
        size = ((((level - 1) * 5) + 10) - (level % 2));
        return (size);
    }

    public static int getXPoints(int level){
        double xPoints = 0;
        xPoints = level * 1000 + Math.pow(((double)level) - 1, 2) * 450;
        return (int)xPoints;
    }

    public static int getNumberOfEnemiesToSpawn(HeroModel hero){
        int level = hero.getLevel();
        int ret = 0;
        
        ret = level + 5;
        return ret;
    }
}