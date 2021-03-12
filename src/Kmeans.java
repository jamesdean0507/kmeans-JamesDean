import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Kmeans 
{

    List<Record> data = new ArrayList<Record>();
    List<Cluster> clusters = new ArrayList<Cluster>();
    Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();

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

    private void initCluster(int clusterNumber, Record record)
    {
        Cluster cluster = new Cluster(clusterNumber, record.getX(), record.getY());
        clusters.add(cluster);
        List<Record> clusterRecord = new ArrayList<Record>();
        clusterRecord.add(record);
        clusterRecords.put(cluster, clusterRecord);
    }

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
                outFile.write("***********RECORD************\n");
                for(Record record : data)
                {
                    outFile.write(record.toString() + "\n");
                }
                outFile.write("***********CLUSTER************\n");
                for(Map.Entry<Cluster, List<Record>> entry : clusterRecords.entrySet())
                {
                    outFile.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                outFile.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        int clusterNumber = Integer.parseInt(args[0]);
        Kmeans k = new Kmeans();
        k.readInput();
        k.launchCluster(clusterNumber);
        k.printData();
    }
}