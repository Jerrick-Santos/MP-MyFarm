package Game;

public class Seed {
    private String name;
    private String cropType;
    private int harvestDayRequired;
    private int daysPassed;
    private Water water;
    private Fertilizer fertilizer;
    private int seedCost;
    private int productsProducedMin;
    private int productsProducedMax;
    private int baseSellingPrice;
    private double expYield;
    private boolean withered;

    public Seed(String name, String cropType, int harvestDayRequired, int daysPassed, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield) {
        this.name = name;
        this.cropType = cropType;
        this.harvestDayRequired = harvestDayRequired;
        this.daysPassed = 0;
        this.water = new Water(waterMin, waterMax);
        this.fertilizer = new Fertilizer(fertilizerMin, fertilizerMax);
        this.seedCost = seedCost;
        this.productsProducedMin = productsProducedMin;
        this.productsProducedMax = productsProducedMax;
        this.baseSellingPrice = baseSellingPrice;
        this.expYield = expYield;
        this.withered = false;
    }

    public void addDaysPassed(){
        this.daysPassed++;
        checkWithered();
    }

    public double computeFinalPrice(FarmerType farmerType){
        double retVal = 0;
        double randomVal = (int)Math.floor(Math.random()*(this.productsProducedMax-this.productsProducedMin+1)+this.productsProducedMin);
        double harvestTotal = 0;
        double waterBonus = 0;
        double fertilizerBonus = 0;
        harvestTotal = randomVal * (this.baseSellingPrice + farmerType.getBonusEarns());
        waterBonus = harvestTotal * 0.2 * (this.water.getTimesCropWatered()-1);
        fertilizerBonus = harvestTotal * 0.5 * this.fertilizer.getTimesCropFertilized();
        retVal = harvestTotal + waterBonus + fertilizerBonus;
        return retVal;
    }

    public void checkWithered(){
        if (!this.withered){
            if (this.daysPassed == this.harvestDayRequired){
                if (this.water.getWaterMin() <= this.water.getTimesCropWatered()
                        && this.fertilizer.getFertilizerMin() <= this.fertilizer.getTimesCropFertilized()){
                    System.out.println("Note: You can now HARVEST your plant!");
                }
                else {
                    this.withered = true;
                    System.out.println("Warning: Your Plant has been withered. Did not meet sufficient water OR fertilizer");
               }
            }
            else if (this.daysPassed > this.harvestDayRequired){
                this.withered = true;
                System.out.println("Warning: Your Plant has been withered. Harvest day has passed");
            }
        }
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

    public int getHarvestDayRequired() {
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
