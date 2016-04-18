public class DataPoint {
    double openBid;


    public DataPoint(double[] rawData) {
        this.openBid = rawData[0];
    }

    public double getOpenBid(){
        return this.openBid;
    }
}
