public class Record 
{
    private int x;
    private int y;
    private int clusterNumber;

    public Record(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getClusterNumber()
    {
        return clusterNumber;
    }

    public void setClusterNumber(int clusterNumber)
    {
        this.clusterNumber = clusterNumber;
    }

    @Override
    public String toString()
    {
        return x + " " + y + " " + clusterNumber;
    }
}
