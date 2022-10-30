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

    public void addWaterMax(int amt) {
        this.waterMax += amt;
    }

    public void addWater(){
        if (this.timesCropWatered < this.waterMax) {
            this.timesCropWatered++;
        }
        else {
            System.out.println("Warning: Can no longer add more water -- Times crop watered is capped at " + this.waterMax);
        }
    }
}
