public class Trade {

    private int tradeId;
    private double enterPip;
    private double exitPip;
    private int size;
    private double stopLoss;
    private double takeProfit;

    public Trade(int tradeId, double enterPip, int size, double stopLoss, double takeProfit) {
        this.tradeId = tradeId;
        this.enterPip = enterPip;
        this.size = size;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
    }

    public void endTrade(double exitPip){
        this.exitPip = exitPip;
    }

    public double getEnterPip(){
        return enterPip;
    }

    public double getEndPip(){
        return exitPip;
    }
}
