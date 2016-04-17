import org.junit.*;

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

        tracker.enterTrade(1.0, 10000, 0.9, 1.2);

        int lenAfter = tracker.activeTrades.size();

        assertEquals(lenAfter - lenBefore, 1);
    }

    // exitTrade test
    // Ensure a trade is ended when exitTrade() is called
    @Test
    public void exitTradeTest(){
        Tracker tracker = new Tracker();
        tracker.enterTrade(1.0, 10000, 0.9, 1.2);

        tracker.exitTrade();

        int lenAfter = tracker.activeTrades.size();

        assertEquals(lenAfter, 0);
    }






}