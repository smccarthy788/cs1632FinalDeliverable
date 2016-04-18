import java.util.ArrayList;
import java.util.Arrays;

public class DataPackage {
    private ArrayList<DataPoint> dataPoints;
    private int numDataPoints;

    public DataPackage(){
        dataPoints = new ArrayList<DataPoint>();
        numDataPoints = 0;
    }

    public DataPackage(DataPoint[] dataPointsToAdd){
        dataPoints = new ArrayList<DataPoint>(Arrays.asList(dataPointsToAdd));
        numDataPoints = dataPointsToAdd.length;
    }

    public void addDataPoint(DataPoint dataPoint){
        dataPoints.add(dataPoint);
        numDataPoints++;
    }

    public int length(){
        return numDataPoints;
    }

}
