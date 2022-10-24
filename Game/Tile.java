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

    public void setPlantedSeed(String name, String cropType, int harvestDayRequired, int daysPassed, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                               int seedCost, int baseSellingPrice, double expYield) {
        this.plantedSeed = new Seed(name, cropType, harvestDayRequired, daysPassed, waterMin, waterMax, fertilizerMin, fertilizerMax, seedCost, baseSellingPrice, expYield);
    }
}
