import java.util.Date;

public class DataPoint {
    double openBid;
    double highBid;
    double lowBid;
    double closeBid;
    
    double openAsk;
    double highAsk;
    double lowAsk;
    double closeAsk;

    Date timeStamp;

    public DataPoint(double[] rawData, Date date) {
        this.openBid = rawData[0];
        this.highBid = rawData[1];
        this.lowBid = rawData[2];
        this.closeBid = rawData[3];
        this.openAsk = rawData[4];
        this.highAsk = rawData[5];
        this.lowAsk = rawData[6];
        this.closeAsk = rawData[7];

        this.timeStamp = date;
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

    public double getLowAsk() {
        return lowAsk;
    }

    public double getCloseAsk() {
        return closeAsk;
    }

    public Date getTimeStamp(){
        return timeStamp;
    }
}
