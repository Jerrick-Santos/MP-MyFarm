package Game;

public class FarmerType {
    private String farmerType;
    private int levelRequirement;
    private int bonusEarns;
    private int costReduction;
    private int waterIncrease;
    private int fertilizerIncrease;
    private double fee;

    public FarmerType() {
        this.farmerType = "Farmer";
        this.levelRequirement = 0;
        this.bonusEarns = 0;
        this.costReduction = 0;
        this.waterIncrease = 0;
        this.fertilizerIncrease = 0;
        this.fee = 0;
    }

    public String getFarmerType() {
        return farmerType;
    }

    public void setFarmerType(String farmerType) {
        this.farmerType = farmerType;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public int getBonusEarns() {
        return bonusEarns;
    }

    public void setBonusEarns(int bonusEarns) {
        this.bonusEarns = bonusEarns;
    }

    public int getCostReduction() {
        return costReduction;
    }

    public void setCostReduction(int costReduction) {
        this.costReduction = costReduction;
    }

    public int getWaterIncrease() {
        return waterIncrease;
    }

    public void setWaterIncrease(int waterIncrease) {
        this.waterIncrease = waterIncrease;
    }

    public int getFertilizerIncrease() {
        return fertilizerIncrease;
    }

    public void setFertilizerIncrease(int fertilizerIncrease) {
        this.fertilizerIncrease = fertilizerIncrease;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
