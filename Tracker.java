import java.util.ArrayList;

public class Tracker {
    public ArrayList<Trade> activeTrades;

    public Tracker(){
        activeTrades = new ArrayList<Trade>();
    }

    public void enterTrade(double enterPip, int size, double stopLoss, double takeProfit) {
        Trade temp = new Trade(enterPip, size, stopLoss, takeProfit);
        activeTrades.add(temp);
    }

    public void exitTrade() {
    }
}
