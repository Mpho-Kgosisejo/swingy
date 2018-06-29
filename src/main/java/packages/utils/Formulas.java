package packages.utils;

public class Formulas{
    public static int sizeMap(int level){
        // Formula: (level-1)*5+10-(level%2) BODMAS
        int size = 0;
        size = ((((level - 1) * 5) + 10) - (level % 2));
        return (size);
    }

    public static int getXPoints(int level){
        // Formula: level*1000+(level − 1)2*450
        int xPoints = 0;
        xPoints = (level * 1000) + (((level - 1) * 2) * 450);
        return (xPoints);
    }
}