package Game;

public class Fertilizer {
    private int fertilizerMin;
    private int fertilizerMax;
    private int timesCropFertilized;

    public Fertilizer(int fertilizerMin, int fertilizerMax) {
        this.fertilizerMin = fertilizerMin;
        this.fertilizerMax = fertilizerMax;
        this.timesCropFertilized = 0;
    }

    public void addFertilizer(){
        if (this.timesCropFertilized < this.fertilizerMax) {
            this.timesCropFertilized++;
        }
        else {
            System.out.println("Warning: Can no longer add more water -- Times watered is capped at " + this.fertilizerMax);
        }
    }

    public int getFertilizerMin() {
        return fertilizerMin;
    }

    public int getFertilizerMax() {
        return fertilizerMax;
    }

    public int getTimesCropFertilized() {
        return timesCropFertilized;
    }

    public void addFertilizerMax(int amt) {
        this.fertilizerMax += amt;
    }
}
