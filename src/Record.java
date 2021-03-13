/**
 * Record class - public
 */
public class Record 
{
    /**
     * Private int, x
     * Stores x value for data-point
     */
    private int x;

    /**
     * Private int, y
     * Stores y value for data-point
     */
    private int y;

    /**
     * Private int, clusterNumber
     */
    private int clusterNumber;

    /**
     * Class constructor
     * @param x
     * @param y
     */
    public Record(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * getX()
     * @return x
     * Public getter method for x
     */
    public int getX()
    {
        return x;
    }

    /**
     * setX()
     * @param x
     * Public setter method for x
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * getY()
     * @return y
     * Public getter method for y
     */
    public int getY()
    {
        return y;
    }

    /**
     * setY()
     * @param y
     * Public setter method for y
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * getClusterNumber()
     * @return clusterNumber
     * Public getter method for clusterNumber
     */
    public int getClusterNumber()
    {
        return clusterNumber;
    }

    /**
     * setClusterNumber()
     * @param clusterNumber
     * Public setter method for clusterNumber
     */
    public void setClusterNumber(int clusterNumber)
    {
        this.clusterNumber = clusterNumber;
    }

    /**
     * toString()
     * @return 
     * Public method returns object Record as a string
     */
    @Override
    public String toString()
    {
        return x + " " + y + " " + clusterNumber;
    }
}
