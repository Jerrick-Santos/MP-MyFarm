package Game;

public class Water {
    private int waterMin;
    private int waterMax;
    private int timesCropWatered;

    public Water(int waterMin, int waterMax) {
        this.waterMin = waterMin;
        this.waterMax = waterMax;
        this.timesCropWatered = 0;
    }

    public int getWaterMin() {
        return waterMin;
    }

    public int getWaterMax() {
        return waterMax;
    }

    public int getTimesCropWatered() {
        return timesCropWatered;
    }

    public void setWaterMax(int waterMax) {
        this.waterMax = waterMax;
    }

    public void addWater(){
        this.timesCropWatered++;
    }
}