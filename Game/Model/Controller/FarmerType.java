package Game.Model.Controller;

/**
 * The FarmerType class contains the necessary information for the player's current
 * farmer type. As the player progresses through the game and levels up, the player
 * is subject for 'prestige leveling' wherein upgrading the farmer type may grant the
 * player benefits such as cost reduction for seeds, water and fertilizer maximum
 * requirement increase, and bonus earnings.
 */
public class FarmerType {
    private String farmerTypeName;
    private int levelRequirement;
    private int bonusEarns;
    private int costReduction;
    private int waterIncrease;
    private int fertilizerIncrease;
    private double fee;

    /**
     * This constructor class is composed of the variables responsible for holding
     * the player's current farmer type.
     */
    public FarmerType() {
        this.farmerTypeName = "Farmer";
        this.levelRequirement = 0;
        this.bonusEarns = 0;
        this.costReduction = 0;
        this.waterIncrease = 0;
        this.fertilizerIncrease = 0;
        this.fee = 0;
    }

    /**
     * Getter class for variable, farmerTypeName.
     * @return name of current farmer type.
     */
    public String getFarmerTypeName() {
        return farmerTypeName;
    }

    /**
     * Setter class for variable farmerTypeName.
     * @param farmerType - new string to be set for farmerTypeName
     */
    public void setFarmerTypeName(String farmerType) {
        this.farmerTypeName = farmerType;
    }

    /**
     * Getter class for variable, levelRequirement.
     * @return level requirement
     */
    public int getLevelRequirement() {
        return levelRequirement;
    }

    /**
     * Setter class for variable levelRequirement.
     * @param levelRequirement - new integer to be set for levelRequirement
     */
    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    /**
     * Getter class for variable, bonusEarns.
     * @return bonus earnings
     */
    public int getBonusEarns() {
        return bonusEarns;
    }

    /**
     * Setter class for variable, bonusEarns.
     * @param bonusEarns - new integer to be set for bonusEarns
     */
    public void setBonusEarns(int bonusEarns) {
        this.bonusEarns = bonusEarns;
    }

    /**
     * Getter class for variable, costReduction.
     * @return cost reduction
     */
    public int getCostReduction() {
        return costReduction;
    }

    /**
     * Setter class for variable, costReduction.
     * @param costReduction - new integer to be set for costReduction
     */
    public void setCostReduction(int costReduction) {
        this.costReduction = costReduction;
    }

    /**
     * Getter class for variable, waterIncrease.
     * @return water increase
     */
    public int getWaterIncrease() {
        return waterIncrease;
    }

    /**
     * Setter class for variable, waterIncrease.
     * @param waterIncrease - new value for variable, waterIncrease.
     */
    public void setWaterIncrease(int waterIncrease) {
        this.waterIncrease = waterIncrease;
    }

    /**
     * Getter class for variable, fertilizerIncrease.
     * @return fertilizer increase
     */
    public int getFertilizerIncrease() {
        return fertilizerIncrease;
    }

    /**
     * Setter class for variable, fertilizerIncrease.
     * @param fertilizerIncrease - new value for variable, fertilizerIncrease.
     */
    public void setFertilizerIncrease(int fertilizerIncrease) {
        this.fertilizerIncrease = fertilizerIncrease;
    }

    /**
     * Getter class for variable, fee.
     * @return registration
     */
    public double getFee() {
        return fee;
    }

    /**
     * Setter class for variable, fee.
     * @param fee - new value for variable, fee.
     */
    public void setFee(double fee) {
        this.fee = fee;
    }
}
