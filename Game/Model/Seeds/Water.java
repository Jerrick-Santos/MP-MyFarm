package Game.Model.Seeds;

import Game.Model.FarmerTypes.FarmerType;

/**
 * The Water Class contains the information needed for watering a particular crop,
 * since water requirements differ across different crops.
 */
public class Water {
    private int waterMin;
    private int waterMax;
    private int timesCropWatered;

    /**
     * This is the constructor class for Water, it takes in specific
     * parameters for minimum and maximum water requirements. It also
     * holds the amount of times a particular crop is watered.
     * @param waterMin - minimum water requirement
     * @param waterMax - maximum water requirement
     */
    public Water(int waterMin, int waterMax, FarmerType farmerType) {
        this.waterMin = waterMin;
        this.waterMax = waterMax + farmerType.getWaterIncrease();
        this.timesCropWatered = 0;
    }

    /**
     * Getter class for variable, waterMin.
     * @return minimum water requirement
     */
    public int getWaterMin() {
        return waterMin;
    }

    /**
     * Getter class for variable, waterMax.
     * @return maximum water requirement
     */
    public int getWaterMax() {
        return waterMax;
    }

    /**
     * Getter class for variable, timesCropWatered.
     * @return times crop was watered
     */
    public int getTimesCropWatered() {
        return timesCropWatered;
    }

    /**
     * When addWaterMax() is called, called-in value for parameter will be
     * added to the maximum water requirement.
     * @param amt - new value to be added to waterMax
     */
    public void addWaterMax(int amt) {
        this.waterMax += amt;
    }

    /**
     * This class adds and counts how many times a crop is watered, as long
     * as it is less than the maximum water requirement.
     */
    public void addWater(){
        if (this.timesCropWatered < this.waterMax) {
            this.timesCropWatered++;
        }
        else {
            System.out.println("Warning: Can no longer add more water -- Times crop watered is capped at " + this.waterMax);
        }
    }
}
