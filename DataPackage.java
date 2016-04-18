import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class DataPackage {
    private ArrayList<DataPoint> dataPoints;
    private int numDataPoints;
    
    private Date startTimeStamp;
    private Date endTimeStamp;

    public DataPackage(){
        dataPoints = new ArrayList<DataPoint>();
        numDataPoints = 0;
    }

    public DataPackage(DataPoint[] dataPointsToAdd){
        dataPoints = new ArrayList<DataPoint>(Arrays.asList(dataPointsToAdd));
        numDataPoints = dataPointsToAdd.length;
        startTimeStamp = dataPointsToAdd[0].getTimeStamp();
        endTimeStamp = dataPointsToAdd[dataPointsToAdd.length - 1].getTimeStamp();
    }

    public void addDataPoint(DataPoint dataPoint){
        dataPoints.add(dataPoint);
        numDataPoints++;
    }

    public int length(){
        return numDataPoints;
    }


    public Date getStartTimeStamp() {
        return startTimeStamp;
    }

    public Date getEndTimeStamp() {
        return endTimeStamp;
    }

    public DataPoint getDataPoint(int index){
        return dataPoints.get(index);
    }
}
