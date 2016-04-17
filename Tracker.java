import java.util.ArrayList;
import java.util.HashMap;

public class Tracker {
    public HashMap<String, Trade> activeTrades;
    public ArrayList<Trade> pastTrades;
    private int numActiveTrades;

    public Tracker(){
        activeTrades = new HashMap<String, Trade>();
        pastTrades = new ArrayList<Trade>();
    }

    public void enterTrade(String currencyPair, double enterPip, int size, double stopLoss, double takeProfit) {
        Trade temp = new Trade(enterPip, size, stopLoss, takeProfit);
        numActiveTrades += 1;
        activeTrades.put(currencyPair, temp);
    }

    public void exitTrade(String currencyPair, double exitPip) {
        Trade toRemove = activeTrades.get(currencyPair);
        toRemove.endTrade(exitPip);
        pastTrades.add(toRemove);
        activeTrades.remove(currencyPair);
    }

    public Trade getTrade(String currencyPair) {
        return activeTrades.get(currencyPair);
    }


}
