public class Feeder {
    int currentPosition;
    DataPackage dataPackage;

    public Feeder(DataPackage dataPackage){
        this.dataPackage = dataPackage;
        currentPosition = 0;
    }

    public DataPoint next(){
        DataPoint toReturn =  this.dataPackage.getDataPoint(currentPosition);
        currentPosition++;
        return toReturn;
    }

}
