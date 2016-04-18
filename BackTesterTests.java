import org.junit.*;

import java.util.Date;

import static org.junit.Assert.*;

public class BackTesterTests {


    /*
    Tracker Tests:
    - enterTrade
    - exitTrade
    - addStopLoss
    - removeStopLoss
    - addTakeProfit
    - removeTakeProfit
    - calculateTradePipProfit

    DataPoint Tests:
    - getHigh bid/ask
    - getLow bid/ask
    - getClose bid/ask
    - getOpen bid/ask


    DataPackage Tests:
    - start and end date are correct
    - number of DataPoints is correct
    - addDataPoint

    Feeder Tests:
    - next

    */

    // Tracker Tests

    // enterTrade test
    // Ensure a trade is begun when enterTrade() is called
    @Test
    public void enterTradeTest() {
        Tracker tracker = new Tracker();

        int lenBefore = tracker.activeTrades.size();

        tracker.enterTrade("EURUSD", 1.0, 10000, 0.9, 1.2);

        int lenAfter = tracker.activeTrades.size();

        assertEquals(lenAfter - lenBefore, 1);
    }

    // exitTrade test
    // Ensure a trade is ended when exitTrade() is called
    @Test
    public void exitTradeTest(){
        Tracker tracker = new Tracker();
        tracker.enterTrade("EURUSD", 1.0, 10000, 0.9, 1.2);

        tracker.exitTrade("EURUSD", 1.2);

        int lenAfter = tracker.activeTrades.size();

        assertEquals(lenAfter, 0);
    }

    @Test
    public void getTradeTest(){
        Tracker tracker = new Tracker();
        tracker.enterTrade("EURUSD", 1.0, 10000, 0.9, 1.2);
        Trade trade = tracker.getTrade("EURUSD");
        assertNotNull(trade);
    }

    @Test
    public void getPastTrade(){
        Tracker tracker = new Tracker();
        int tradeId = tracker.enterTrade("EURUSD", 1.0, 10000, 0.9, 1.2);
        tracker.exitTrade("EURUSD", 1.2);

        Trade trade = tracker.getPastTrade(tradeId);

        assertNotNull(trade);
    }

    @Test
    public void calculateTradePipProfitTest(){
        Tracker tracker = new Tracker();
        int tradeId = tracker.enterTrade("EURUSD", 1.0, 10000, 0.9, 1.2);
        tracker.exitTrade("EURUSD", 1.2);

        double pipProfit = tracker.getProfit(tradeId);

        assertEquals(pipProfit, .2);
    }




}