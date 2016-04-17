public class Trade {

    private double enterPip;
    private double exitPip;
    private int size;
    private double stopLoss;
    private double takeProfit;

    public Trade(double enterPip, int size, double stopLoss, double takeProfit) {
        this.enterPip = enterPip;
        this.size = size;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
    }

    public void endTrade(double exitPip){
        this.exitPip = exitPip;
    }
}
