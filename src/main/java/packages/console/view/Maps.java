package packages.console.view;

import packages.models.HeroModel;
import packages.utils.Formulas;
import static packages.utils.Colours.*;

public class Maps
{
    public int map[][];
    public void drawMap(HeroModel hero)
    {
        int sideLength = Formulas.sizeMap(hero.getLevel());

        for (int x = 0; x < sideLength; x++) {
            for (int y = 0; y < sideLength; y++) {
                if (hero.getCoordinates().getY() == y && hero.getCoordinates().getX() == x )
                    System.out.print(ANSI_PURPLE + "0 " + ANSI_RESET);
                else
                    System.out.print("* ");
            }
            System.out.println(""); //Short for new line.
        }
    }
}