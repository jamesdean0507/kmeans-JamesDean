/**
 * Cluster class - public
 */
public class Cluster 
{
    /**
     * Private int, xCentroid
     * Mean x value for cluster
     */
    private int xCentroid;

    /**
     * Private int, yCentroid
     * Mean y value for cluster
     */
    private int yCentroid;

    /**
     * Private int, clusterNumber
     */
    private int clusterNumber;

    /**
     * Class Constructor
     * @param clusterNumber
     * @param xCentroid
     * @param yCentroid
     */
    public Cluster(int clusterNumber, int xCentroid, int yCentroid)
    {
        super();
        this.clusterNumber = clusterNumber;
        this.xCentroid = xCentroid;
        this.yCentroid = yCentroid;
    }

    /**
     * getXCentroid()
     * @return xCentroid
     * Public getter method for x value centroid 
     */
    public int getXCentroid()
    {
        return xCentroid;
    }

    /**
     * setXCentroid()
     * @param xCentroid
     * Public setter method for x centroid
     */
    public void setXCentroid(int xCentroid)
    {
        this.xCentroid = xCentroid;
    }

    /**
     * getYCentroid()
     * @return yCentroid
     * Public getter method for y value centroid 
     */
    public int getYCentroid()
    {
        return yCentroid;
    }

    /**
     * setYCentroid()
     * @param yCentroid
     * Public setter method for y centroid
     */
    public void setYCentroid(int yCentroid)
    {
        this.yCentroid = yCentroid;
    }

    /**
     * getClusterNumber()
     * @return clusterNumber
     * Public getter method for x value centroid 
     */
    public int getClusterNumber()
    {
        return clusterNumber;
    }

    /**
     * setXCentroid()
     * @param clusterNumber
     * Public setter method for cluster number
     */
    public void setClusterNumber(int clusterNumber)
    {
        this.clusterNumber = clusterNumber;
    }

    /**
     * euclideanDistance()
     * @param record
     * @return 
     * Public double method to calculate euclidean distance
     */
    public double euclideanDistance(Record record)
    {
        return Math.sqrt(Math.pow((getXCentroid() - record.getX()), 2) + Math.pow((getYCentroid() - record.getY()), 2));
    }

    /**
     * updateCentroid()
     * @param record
     * Public method that updates the centroid
     * by calculating the mean x and y values
     */
    public void updateCentroid(Record record)
    {
        setXCentroid((getXCentroid() + record.getX()) / 2);
        setYCentroid((getYCentroid() + record.getY()) / 2);
    }

    /**
     * tpString()
     * @return 
     * Public method returns object Cluster as a string
     */
    @Override
    public String toString()
    {
        return xCentroid + " " + yCentroid + " " + clusterNumber;
    }
}
