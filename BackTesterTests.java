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

        int lenBefore = tracker.activeTrades.length;

        tracker.enterTrade();

        int lenAfter = tracker.activeTrades.length;

        assertEquals(lenAfter - lenBefore, 1);
    }

    // exitTrade test
    // Ensure a trade is ended when exitTrade() is called
    @Test
    public void exitTradeTest(){
        Tracker tracker = new Tracker();

        int lenBefore = tracker.activeTrades.length;

        tracker.exitTrade();

        int lenAfter = tracker.activeTrades.length;

        assertEquals(lenAfter - lenBefore, 1);
    }






}