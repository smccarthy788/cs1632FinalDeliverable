public class DataPoint {
    double openBid;
    double highBid;
    double lowBid;


    public DataPoint(double[] rawData) {
        this.openBid = rawData[0];
        this.highBid = rawData[1];
        this.lowBid = rawData[2];
    }

    public double getOpenBid(){
        return openBid;
    }

    public double getHighBid() {
        return highBid;
    }

    public double getLowBid() {
        return lowBid;
    }
}
