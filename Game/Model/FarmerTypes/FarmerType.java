package Game.Model.FarmerTypes;

/**
 * The FarmerType class contains the necessary information for the player's current
 * farmer type. As the player progresses through the game and levels up, the player
 * is subject for 'prestige leveling' wherein upgrading the farmer type may grant the
 * player benefits such as cost reduction for seeds, water and fertilizer maximum
 * requirement increase, and bonus earnings.
 */
public abstract class FarmerType {
    private String farmerTypeName;
    private int levelRequirement;
    private int bonusEarns;
    private int costReduction;
    private int waterIncrease;
    private int fertilizerIncrease;
    private double fee;

    public FarmerType(String farmerTypeName, int levelRequirement, int bonusEarns,
                      int costReduction, int waterIncrease,
                      int fertilizerIncrease, double fee) {
        this.farmerTypeName = farmerTypeName;
        this.levelRequirement = levelRequirement;
        this.bonusEarns = bonusEarns;
        this.costReduction = costReduction;
        this.waterIncrease = waterIncrease;
        this.fertilizerIncrease = fertilizerIncrease;
        this.fee = fee;
    }


    /**
     * Getter class for variable, farmerTypeName.
     * @return name of current farmer type.
     */
    public String getFarmerTypeName() {
        return farmerTypeName;
    }


    /**
     * Getter class for variable, levelRequirement.
     * @return level requirement
     */
    public int getLevelRequirement() {
        return levelRequirement;
    }

    /**
     * Getter class for variable, bonusEarns.
     * @return bonus earnings
     */
    public int getBonusEarns() {
        return bonusEarns;
    }

    /**
     * Getter class for variable, costReduction.
     * @return cost reduction
     */
    public int getCostReduction() {
        return costReduction;
    }


    /**
     * Getter class for variable, waterIncrease.
     * @return water increase
     */
    public int getWaterIncrease() {
        return waterIncrease;
    }

    /**
     * Getter class for variable, fertilizerIncrease.
     * @return fertilizer increase
     */
    public int getFertilizerIncrease() {
        return fertilizerIncrease;
    }

    /**
     * Getter class for variable, fee.
     * @return registration
     */
    public double getFee() {
        return fee;
    }

}
