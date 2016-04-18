import java.util.ArrayList;

public class DataPackage {
    private ArrayList<DataPoint> dataPoints;
    private int numDataPoints;

    public DataPackage(){
        dataPoints = new ArrayList<DataPoint>();
        numDataPoints = 0;
    }

    public void addDataPoint(DataPoint dataPoint){
        dataPoints.add(dataPoint);
        numDataPoints++;
    }

    public int length(){
        return numDataPoints;
    }

}
