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

    public Seed(String name, String cropType, String harvestDayRequired, int daysPassed, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                int seedCost, int baseSellingPrice, double expYield) {
        this.name = name;
        this.cropType = cropType;
        this.harvestDayRequired = harvestDayRequired;
        this.daysPassed = 0;
        this.water = new Water(waterMin, waterMax);
        this.fertilizer = new Fertilizer(fertilizerMin, fertilizerMax);
        this.seedCost = seedCost;
        this.baseSellingPrice = baseSellingPrice;
        this.expYield = expYield;
        this.withered = false;
    }

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
