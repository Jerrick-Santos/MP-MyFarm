package Game.Model.Controller;

import Game.Model.FarmerTypes.FarmerType;
import Game.Model.Seeds.*;

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
        this.occupied = true;
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

    public void setPlantedSeed(int select, String name, String cropType, int harvestDayRequired,
                               int waterMin, int waterMax, int fertilizerMin, int fertilizerMax,
                               int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield, FarmerType farmerType) {

        if (!this.rock && !this.occupied && this.plowed && this.plantedSeed == null){
            if (select == 0){
                this.plantedSeed = new Turnip(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            }
            else if (select == 1){
                this.plantedSeed = new Carrot(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 2) {
                this.plantedSeed = new Potato(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 3){
                this.plantedSeed = new Rose(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 4){
                this.plantedSeed = new Tulips(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 5){
                this.plantedSeed = new Sunflower(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 6){
                this.plantedSeed = new Mango(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            } else if (select == 7){
                this.plantedSeed = new Apple(name, cropType, harvestDayRequired,
                        waterMin, waterMax,
                        fertilizerMin, fertilizerMax,
                        seedCost, productsProducedMin,
                        productsProducedMax, baseSellingPrice, expYield, farmerType);
            }


            this.occupied = true;
        }

    }
}
