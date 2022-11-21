package Game.Model.Seeds;

import Game.Model.FarmerTypes.FarmerType;

/**
 * The Fertilizer Class contains the information needed for fertilizing a
 * particular crop, since fertilizer requirements differ across different crops.
 */
public class Fertilizer {
    private int fertilizerMin;
    private int fertilizerMax;
    private int timesCropFertilized;

    /**
     * This is the constructor class for Fertilizer, it takes in
     * specific parameters for minimum and maximum fertilizer requirements.
     * It also holds the amount of times a particular crop is fertilized.
     * @param fertilizerMin - minimum fertilizer requirement
     * @param fertilizerMax - maximum fertilizer requirement
     */
    public Fertilizer(int fertilizerMin, int fertilizerMax, FarmerType farmerType) {
        this.fertilizerMin = fertilizerMin;
        this.fertilizerMax = fertilizerMax + farmerType.getFertilizerIncrease();
        this.timesCropFertilized = 0;
    }

    /**
     * This class adds and counts how many times a crop is fertilized,
     * as long as it is less than the maximum fertilizer requirement.
     */
    public void addFertilizer(){
        if (this.timesCropFertilized < this.fertilizerMax) {
            this.timesCropFertilized++;
        }
        else {
            System.out.println("Warning: Can no longer add more fertilizer -- Times crop fertilized is capped at " + this.fertilizerMax);
        }
    }

    /**
     * Getter class for variable, fertilizerMin.
     * @return minimum fertilizer requirement
     */
    public int getFertilizerMin() {
        return fertilizerMin;
    }

    /**
     * Getter class for variable, fertilizerMax.
     * @return maximum fertilizer requirement
     */
    public int getFertilizerMax() {
        return fertilizerMax;
    }

    /**
     * Getter class for variable, timesCropFertilized.
     * @return times crop was fertilized
     */
    public int getTimesCropFertilized() {
        return timesCropFertilized;
    }

    /**
     * When addFertilizerMax() is called, called-in value for parameter
     * will be added to the maximum fertilizer requirement.
     * @param amt - new value to be added to fertilizerMax
     */
    public void addFertilizerMax(int amt) {
        this.fertilizerMax += amt;
    }
}
