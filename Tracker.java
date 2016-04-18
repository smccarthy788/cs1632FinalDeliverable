import java.util.ArrayList;
import java.util.HashMap;

public class Tracker {
    public HashMap<String, Trade> activeTrades;
    public HashMap<Integer, Trade> pastTrades;
    private int numActiveTrades;
    private int numPastTrades;

    public Tracker(){
        activeTrades = new HashMap<String, Trade>();
        pastTrades = new HashMap<Integer, Trade>();
    }

    public int enterTrade(String currencyPair, double enterPip, int size, double stopLoss, double takeProfit) {
        int tradeId = numActiveTrades + numPastTrades + 1;
        Trade temp = new Trade(tradeId, enterPip, size, stopLoss, takeProfit);
        numActiveTrades += 1;
        activeTrades.put(currencyPair, temp);

        return tradeId;
    }

    public void exitTrade(String currencyPair, double exitPip) {
        Trade toRemove = activeTrades.get(currencyPair);
        toRemove.endTrade(exitPip);
        numPastTrades += 1;
        pastTrades.put(numPastTrades, toRemove);
        activeTrades.remove(currencyPair);
    }

    public Trade getTrade(String currencyPair) {
        return activeTrades.get(currencyPair);
    }


    public Trade getPastTrade(int tradeId) {
        return pastTrades.get(tradeId);
    }

    public double getProfit(int tradeId) {
        Trade trade = getPastTrade(tradeId);

    }
}
