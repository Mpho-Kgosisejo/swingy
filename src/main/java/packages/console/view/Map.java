package packages.console.view;

import packages.models.HeroModel;

public class Map
{
    public int map[][];
    public void drawMap(HeroModel hero)
    {
        int sideLength = 38;
        int a = sideLength / 2;
        for (int x = 0; x < sideLength; x++) {
            for (int y = 0; y < sideLength; y++) {
                if (a == y && a == x )
                    System.out.print("0 ");
                else
                    System.out.print("* ");
            }
            System.out.println(""); //Short for new line.
        }
    }
}