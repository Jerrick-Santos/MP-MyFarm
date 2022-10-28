package Game;

import Game.Tool;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private String name;
    private int level;
    private int passedDays;
    private FarmerType farmerType;
    private GameStats gameStats;
    private Tile land;
    private ArrayList<Tool> toolSetList;
    private int selectedTool;

    public Player(String name, Tool tool1, Tool tool2, Tool tool3, Tool tool4, Tool tool5) {
        this.name = name;
        this.level = 0;
        this.passedDays = 0;
        this.farmerType = new FarmerType();
        this.gameStats = new GameStats();
        this.land = new Tile();
        this.toolSetList = new ArrayList<>(Arrays.asList(tool1, tool2, tool3, tool4, tool5));
        this.selectedTool = -1;
    }

    public boolean endGame(){ //currently only works on a single tile
        boolean retVal = false;

        if (this.gameStats.getBalance() < 5 && this.land.getPlantedSeed() != null &&
        this.land.getPlantedSeed().isWithered()){
            retVal = true;
        }

        return retVal;
    }

    public void nextDay(){

    }

    public void equipTool(int toolIndex){

        if (toolIndex >= 0 && toolIndex < 5){
            this.selectedTool = toolIndex;
        }
        else{
            System.out.println("Warning: Invalid Tool Selection");
        }
    }
    
    public void harvestPlant() {
        if (!this.land.getPlantedSeed().isWithered()){
            this.gameStats.addWallet(this.land.getPlantedSeed().computeFinalPrice(this.farmerType));
            this.gameStats.gainExp(this.land.getPlantedSeed().getExpYield());
            this.land.removePlantedSeed();
            this.land.setOccupied(false);
            this.land.setPlowed(false);
        }
        else {
            System.out.println("WARNING!! Plant is withered! Use the shovel!");
        }
    }

    public boolean updateLevel() {
        boolean retVal = false;
        if (gameStats.getExp() >= 100 && gameStats.getExp() < 200 && this.level < 1){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 200 && gameStats.getExp() < 300 && this.level < 2){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 300 && gameStats.getExp() < 400 && this.level < 3){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 400 && gameStats.getExp() < 500 && this.level < 4){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 500 && gameStats.getExp() < 600 && this.level < 5){
            this.level++;
            retVal = true;
        }
        return retVal;
    }

    public void updateFarmerType(int choice) {
        if (this.level >= 5 && this.level < 10) {
            if (choice == 1) {
                this.farmerType.setFarmerTypeName("Registered Farmer");
                this.farmerType.setBonusEarns(1);
                this.farmerType.setCostReduction(1);
                this.farmerType.setFee(200);
                this.gameStats.deductWallet(this.farmerType.getFee());
            }
        } else if (this.level >= 10 && this.level < 15) {
            if (choice == 1) {
                this.farmerType.setFarmerTypeName("Distinguished Farmer");
                this.farmerType.setBonusEarns(2);
                this.farmerType.setCostReduction(2);
                this.farmerType.setWaterIncrease(1);
                this.farmerType.setFee(300);
                this.gameStats.deductWallet(this.farmerType.getFee());
            }
        }
    }

    public FarmerType getFarmerType() {
        return farmerType;
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
