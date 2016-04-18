public class DataPoint {
    double openBid;
    double highBid;


    public DataPoint(double[] rawData) {
        this.openBid = rawData[0];
        this.highBid = rawData[1];
    }

    public double getOpenBid(){
        return this.openBid;
    }

    public double getHighBid() {
        return this.highBid;
    }
}
