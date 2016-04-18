public class DataPoint {
    double openBid;
    double highBid;
    double lowBid;
    double closeBid;
    
    double openAsk;
    double highAsk;

    public DataPoint(double[] rawData) {
        this.openBid = rawData[0];
        this.highBid = rawData[1];
        this.lowBid = rawData[2];
        this.closeBid = rawData[3];
        this.openAsk = rawData[4];
        this.highAsk = rawData[5];
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

    public double getCloseBid() {
        return closeBid;
    }

    public double getOpenAsk() {
        return openAsk;
    }

    public double getHighAsk() {
        return highAsk;
    }
}
