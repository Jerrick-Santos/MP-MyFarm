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
        this.timesCropFertilized++;
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

    public void setFertilizerMax(int fertilizerMax) {
        this.fertilizerMax = fertilizerMax;
    }
}
