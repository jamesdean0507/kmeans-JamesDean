import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Kmeans Class - public
 */
public class Kmeans 
{

    /**
     * ArrayList, data, of Records
     */
    List<Record> data = new ArrayList<Record>();

    /**
     * ArrayList, clusters, of Clusters
     */
    List<Cluster> clusters = new ArrayList<Cluster>();

    /**
     * HashMap, clusterRecords
     * @key Cluster
     * @value ArrayList of Records
     */
    Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();

    /**
     * readInput()
     * Private method to scan input, create a record for each data-point
     */
    private void readInput()
    {
        try 
        {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            File inFile = new File(s + "/src/input.txt");
            Scanner scnr = new Scanner(inFile);
            while (scnr.hasNextLine())
            {
                String txt = scnr.nextLine();
                String[] parse = txt.split(" ");
                int x = Integer.parseInt(parse[0]);
                int y = Integer.parseInt(parse[1]);
                Record record = new Record(x, y);
                data.add(record);
            }
            scnr.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("ERR: Input File Not Found.");
            e.printStackTrace();
        }
    }

    /**
     * launchCluster()
     * @param clusterNumber
     * Private method iterates through each record in the 
     * ArrayList, data, to find the nearest centroid.
     * Then the HashMap is updated.
     */
    private void launchCluster(int clusterNumber)
    {
        int n = 1;
        Iterator<Record> iterator = data.iterator();
        Record record = null;

        while(iterator.hasNext()) 
        {
            record = iterator.next();
            if(n <= clusterNumber)
            {
                record.setClusterNumber(n);
                initCluster(n, record);
                n++;
            }
            else
            {
                double min = Integer.MAX_VALUE;
                Cluster clusterInstance = null;

                for(Cluster cluster : clusters)
                {
                    double distance = cluster.euclideanDistance(record);
                    if(min > distance)
                    {
                        min = distance;
                        clusterInstance = cluster;
                    }
                }
                record.setClusterNumber(clusterInstance.getClusterNumber());
                clusterInstance.updateCentroid(record);
                clusterRecords.get(clusterInstance).add(record);
            }
        }
    }

    /**
     * initCluster()
     * @param clusterNumber
     * @param record
     * Private method used to create a cluster instance
     * and add it to the HashMap
     */
    private void initCluster(int clusterNumber, Record record)
    {
        Cluster cluster = new Cluster(clusterNumber, record.getX(), record.getY());
        clusters.add(cluster);
        List<Record> clusterRecord = new ArrayList<Record>();
        clusterRecord.add(record);
        clusterRecords.put(cluster, clusterRecord);
    }

    /**
     * printData()
     * Private method, opens/creates an output file.
     * Then the ArrayList of records is iterated through
     * and written to the output file
     */
    private void printData()
    {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File file = new File(s + "/src/output.txt");

        if(!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch(IOException e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
        else
        {
            try
            {
                FileWriter outFile = new FileWriter(file);
                for(Record record : data)
                {
                    outFile.write(record.toString() + "\n");
                }
                outFile.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    /**
     * main()
     * @param args
     */
    public static void main(String[] args)
    {
        int clusterNumber = Integer.parseInt(args[0]);
        Kmeans k = new Kmeans();
        k.readInput();
        k.launchCluster(clusterNumber);
        k.printData();
    }
}