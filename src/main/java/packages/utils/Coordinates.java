package packages.utils;

public class Coordinates
{
    private int x;
    private int y;

    Coordinates(int xAxis, int yAxis)
    {
        this.y = yAxis;
        this.x = xAxis;
    }

    public int getX()
    {
        return (this.x);
    }

    public int getY()
    {
        return (this.y);
    }
}