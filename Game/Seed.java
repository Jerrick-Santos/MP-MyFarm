package Game;

public class Seed {
    private String name;
    private String cropType;
    private String harvestDayRequired;
    private int daysPassed;
    private Water water;
    private Fertilizer fertilizer;
    private int seedCost;
    private int baseSellingPrice;
    private double expYield;
    private boolean withered;

    public void addDaysPassed(){
        this.daysPassed++;
    }

    public double computeFinalPrice(FarmerType farmerType){
        double retVal = 0;
        return retVal;
    }

    public void setWithered(boolean withered) {
        this.withered = withered;
    }

    public String getName() {
        return name;
    }

    public String getCropType() {
        return cropType;
    }

    public String getHarvestDayRequired() {
        return harvestDayRequired;
    }

    public int getDaysPassed() {
        return daysPassed;
    }

    public Water getWater() {
        return water;
    }

    public Fertilizer getFertilizer() {
        return fertilizer;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getBaseSellingPrice() {
        return baseSellingPrice;
    }

    public double getExpYield() {
        return expYield;
    }

    public boolean isWithered() {
        return withered;
    }
}
