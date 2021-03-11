public class Cluster 
{
    private int xCentroid;
    private int yCentroid;
    private int clusterNumber;

    public Cluster(int clusterNumber, int xCentroid, int yCentroid)
    {
        super();
        this.clusterNumber = clusterNumber;
        this.xCentroid = xCentroid;
        this.yCentroid = yCentroid;
    }

    public int getXCentroid()
    {
        return xCentroid;
    }

    public void setXCentroid(int xCentroid)
    {
        this.xCentroid = xCentroid;
    }

    public int getYCentroid()
    {
        return yCentroid;
    }

    public void setYCentroid(int yCentroid)
    {
        this.yCentroid = yCentroid;
    }

    public int getClusterNumber()
    {
        return clusterNumber;
    }

    public void setClusterNumber(int clusterNumber)
    {
        this.clusterNumber = clusterNumber;
    }

    public double euclideanDistance(Record record)
    {
        return Math.sqrt(Math.pow((getXCentroid() - record.getX()), 2) + Math.pow((getYCentroid() - record.getY()), 2));
    }

    public void updateCentroid(Record record)
    {
        setXCentroid((getXCentroid() + record.getX()) / 2);
        setYCentroid((getYCentroid() + record.getY()) / 2);
    }

    @Override
    public String toString()
    {
        return clusterNumber + "/" + xCentroid + "-" + yCentroid;
    }
}
