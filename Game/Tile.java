package Game;

public class Tile {
    private boolean rock;
    private boolean occupied;
    private boolean plowed;
    private Seed plantedSeed;

    public Tile() {
        this.rock = false;
        this.occupied = false;
        this.plowed = false;
        this.plantedSeed = null;
    }

    public boolean isRock() {
        return rock;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isPlowed() {
        return plowed;
    }

    public Seed getPlantedSeed() {
        return plantedSeed;
    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setPlowed(boolean plowed) {
        this.plowed = plowed;
    }

    public void removePlantedSeed(){
        if (this.plantedSeed != null){
            this.plantedSeed = null;
        }
    }

    public void setPlantedSeed(String name, String cropType, int harvestDayRequired, int daysPassed,
                               int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                               int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield) {

        if (!this.rock && !this.occupied && this.plowed && this.plantedSeed == null){
            this.plantedSeed = new Seed(name, cropType, harvestDayRequired, daysPassed,
                    waterMin, waterMax, fertilizerMin, fertilizerMax,
                    seedCost, productsProducedMin, productsProducedMax, baseSellingPrice, expYield);
            this.occupied = true;
        }

    }
}
