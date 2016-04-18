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

        assertEquals(pipProfit, 0.2, 1e-15);
    }

    // DataPoint Test
    // Use rawData to initialize all dataPoints
        // rawData : openBid, highBid, lowBid, closeBid, openAsk, highAsk, lowAsk, closeAsk
    double rawData[] = {1.0, 1.5, 0.5, 1.0, 1.1, 1.6, 0.6, 1.1};

    // getOpenBid Test
    @Test
    public void getOpenBidTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double openBid = dataPoint.getOpenBid();

        assertEquals(openBid, 1.0, 1e-15);
    }

    // getHighBid Test
    @Test
    public void getHighBidTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double highBid = dataPoint.getHighBid();

        assertEquals(highBid, 1.5, 1e-15);
    }

    // getLowBid Test
    @Test
    public void getLowBidTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double lowBid = dataPoint.getLowBid();

        assertEquals(lowBid, 0.5, 1e-15);
    }

    // getCloseBid Test
    @Test
    public void getCloseBidTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double closeBid = dataPoint.getCloseBid();

        assertEquals(closeBid, 1.0, 1e-15);
    }

    // getOpenAsk Test
    @Test
    public void getOpenAskTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double openAsk = dataPoint.getOpenAsk();

        assertEquals(openAsk, 1.1, 1e-15);
    }

    // getHighAsk Test
    @Test
    public void getHighAskTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double highAsk = dataPoint.getHighAsk();

        assertEquals(highAsk, 1.6, 1e-15);
    }

    // getLowAsk Test
    @Test
    public void getLowAskTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double lowAsk = dataPoint.getLowAsk();

        assertEquals(lowAsk, 0.6, 1e-15);
    }

    // getCloseAsk Test
    @Test
    public void getCloseAskTest(){
        DataPoint dataPoint = new DataPoint(rawData, new Date());
        double closeAsk = dataPoint.getCloseAsk();

        assertEquals(closeAsk, 1.1, 1e-15);
    }

    // DataPackage Tests

    // addDataPoint Test
    @Test
    public void addDataPointTest(){
        DataPackage dataPackage = new DataPackage();
        DataPoint dataPoint = new DataPoint(rawData, new Date());

        dataPackage.addDataPoint(dataPoint);

        assertEquals(dataPackage.length(), 1);
    }

    // DataPackage construction from multiple dataPoints
    @Test
    public void dataPackageMultiPointConstructionTest(){
        DataPoint[] dataPoints = new DataPoint[3];
        DataPoint dataPoint1 = new DataPoint(rawData, new Date());
        dataPoints[0] = dataPoint1;
        DataPoint dataPoint2 = new DataPoint(rawData, new Date());
        dataPoints[1] = dataPoint2;
        DataPoint dataPoint3 = new DataPoint(rawData, new Date());
        dataPoints[2] = dataPoint3;

        DataPackage dataPackage = new DataPackage(dataPoints);

        assertEquals(dataPackage.length(), 3);
    }

    // DataPackage startDate test
    @Test
    public void dataPackageStartDateTest() throws InterruptedException {
        DataPoint[] dataPoints = new DataPoint[1];

        Date date = new Date(System.currentTimeMillis());
        dataPoints[0] = new DataPoint(rawData, date);

        DataPackage dataPackage = new DataPackage(dataPoints);

        assertEquals(dataPackage.getStartTimeStamp(), date);
    }

    // DataPackage endDate test
    @Test
    public void dataPackageEndDateTest(){
        DataPoint[] dataPoints = new DataPoint[1];

        Date date = new Date(System.currentTimeMillis());
        dataPoints[0] = new DataPoint(rawData, date);

        DataPackage dataPackage = new DataPackage(dataPoints);

        assertEquals(dataPackage.getEndTimeStamp(), date);
    }

    // DataPackage timeLength test
    @Test
    public void dataPackageTimeLengthTest() throws InterruptedException {
        DataPoint[] dataPoints = new DataPoint[2];
        dataPoints[0] = new DataPoint(rawData, new Date(System.currentTimeMillis()));
        Thread.sleep(1000);
        dataPoints[1] = new DataPoint(rawData, new Date(System.currentTimeMillis()));
        DataPackage dataPackage = new DataPackage(dataPoints);

        assertEquals(dataPackage.getEndTimeStamp().getTime() - dataPackage.getStartTimeStamp().getTime(), 1000.0, 1e-15);
    }

    // Feeder Tests

    // Feeder.next() test
    @Test
    public void feederNextTest(){
        DataPoint[] dataPoints = {new DataPoint(rawData, new Date(System.currentTimeMillis()))}
        DataPackage dataPackage = new DataPackage(dataPoints);
        Feeder feeder = new Feeder(dataPackage);

        DataPoint dataPoint = feeder.next();

        assertNotNull(dataPoint);
    }




}