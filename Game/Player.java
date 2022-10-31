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
        if (this.land.getPlantedSeed() != null && this.land.isPlowed()){
            this.land.getPlantedSeed().addDaysPassed();
            this.land.getPlantedSeed().checkWithered();
        }
        this.passedDays++;
        System.out.println("Passed Days: " + this.passedDays);
    }

    public void equipTool(int toolIndex){
        if (toolIndex >= 0 && toolIndex < 5){
            this.selectedTool = toolIndex;
        }
        else{
            System.out.println("Warning: Invalid Tool Selection");
        }
    }

    public void plant(int select){
        if (this.land.isPlowed() && !this.land.isOccupied()
        && this.land.getPlantedSeed() == null){
            if (select == 0 && this.gameStats.getBalance() >= 5 - farmerType.getCostReduction()){
                this.land.setPlantedSeed("Turnip", "Root Crop", 2,
                        1,2,
                        0,1,
                        5,
                        1,2,
                        6,5);
                this.gameStats.deductWallet(5 - farmerType.getCostReduction());
            }
            else if (select == 1 && this.gameStats.getBalance() >= 10 - farmerType.getCostReduction()){
                this.land.setPlantedSeed("Carrot", "Root Crop", 3,
                        1,2,
                        0,1,
                        10,
                        1,2,
                        9,7.5);
                this.gameStats.deductWallet(10 - farmerType.getCostReduction());
            }
            else if (select == 2 && this.gameStats.getBalance() >= 20 - farmerType.getCostReduction()){
                this.land.setPlantedSeed("Potato", "Root Crop", 5,
                        3,4,
                        1,2,
                        20,
                        1,10,
                        3,12.5);
                this.gameStats.deductWallet(20 - farmerType.getCostReduction());
            }
            else{
                System.out.println("Warning: Insufficient OBJCs to buy chosen seed!");
            }
        }
        else {
            System.out.println("Warning: cannot be planted!");
        }
    }



    public void harvestPlant() {
        if (this.land.getPlantedSeed() != null && this.land.isPlowed()
            && !this.land.getPlantedSeed().isWithered()
            && this.land.getPlantedSeed().getHarvestDayRequired() == this.land.getPlantedSeed().getDaysPassed()){
            System.out.println(this.land.getPlantedSeed().getName() + " has been harvested.");
            this.gameStats.addWallet(this.land.getPlantedSeed().computeFinalPrice(this.farmerType));
            this.gameStats.gainExp(this.land.getPlantedSeed().getExpYield());
            this.land.removePlantedSeed();
            this.land.setOccupied(false);
            this.land.setPlowed(false);
        }
        else if (this.land.getPlantedSeed().isWithered()){
            System.out.println("Warning: Plant is withered! Use the shovel!");
        }
        else {
            System.out.println("Warning: Harvest Day Required not met.");
        }
    }

    public void useEquippedTool(){
        if (this.selectedTool != -1){
            if (this.selectedTool == 0){ //WaterCan
                if (this.toolSetList.get(selectedTool).useTool(this.land)){
                    this.gameStats.gainExp(0.5);
                }
            }
            else if (this.selectedTool == 1 && this.gameStats.getBalance() >= 10){ //fertilizer
                if (this.toolSetList.get(selectedTool).useTool(this.land)){
                    this.gameStats.gainExp(4);
                    this.gameStats.deductWallet(10);
                }
            }
            else if (this.selectedTool == 2){ //Plow
                if (this.toolSetList.get(selectedTool).useTool(this.land)){
                    this.gameStats.gainExp(0.5);
                }
            }
            else if (this.selectedTool == 3 && this.gameStats.getBalance() >= 50){ //Pickaxe
                if (this.toolSetList.get(selectedTool).useTool(this.land)){
                    this.gameStats.gainExp(15);
                    this.gameStats.deductWallet(50);
                }
            }
            else if (this.selectedTool == 4 && this.gameStats.getBalance() >= 7){ //Shovel
                if (this.toolSetList.get(selectedTool).useTool(this.land)){
                    this.gameStats.gainExp(2);
                    this.gameStats.deductWallet(7);
                }
            }
            else {
                System.out.println("Cannot use tool: Conditions are not met");
            }
        }
        else {
            System.out.println("Warning: Tool not Equipped.");
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
        } else if (gameStats.getExp() >= 600 && gameStats.getExp() < 700 && this.level < 6){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 700 && gameStats.getExp() < 800 && this.level < 7){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 800 && gameStats.getExp() < 900 && this.level < 8){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 900 && gameStats.getExp() < 1000 && this.level < 9){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 1000 && gameStats.getExp() < 1100 && this.level < 10){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 1100 && gameStats.getExp() < 1200 && this.level < 11){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 1200 && gameStats.getExp() < 1300 && this.level < 12){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 1300 && gameStats.getExp() < 1400 && this.level < 13){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 1400 && gameStats.getExp() < 1500 && this.level < 14){
            this.level++;
            retVal = true;
        } else if (gameStats.getExp() >= 1500 && this.level < 15){
            this.level++;
            retVal = true;
        }


        if (retVal){
            System.out.println("Game: Level Up to " + this.level);
        }

        return retVal;
    }

    public void updateFarmerType(int choice) {
        if (this.level >= 5 && this.level < 10 && !this.farmerType.getFarmerTypeName().equals("Registered Farmer")) {
            if (choice == 1) {
                this.farmerType.setFarmerTypeName("Registered Farmer");
                this.farmerType.setBonusEarns(1);
                this.farmerType.setCostReduction(1);
                this.farmerType.setFee(200);
                this.gameStats.deductWallet(this.farmerType.getFee());
            }
        } else if (this.level >= 10 && this.level < 15 && !this.farmerType.getFarmerTypeName().equals("Distinguished Farmer")) {
            if (choice == 1) {
                this.farmerType.setFarmerTypeName("Distinguished Farmer");
                this.farmerType.setBonusEarns(2);
                this.farmerType.setCostReduction(2);
                this.farmerType.setWaterIncrease(1);

                if (this.land.getPlantedSeed() != null && !this.land.getPlantedSeed().isWithered()){
                    this.land.getPlantedSeed().getWater().addWaterMax(this.farmerType.getWaterIncrease());
                }

                this.farmerType.setFee(300);
                this.gameStats.deductWallet(this.farmerType.getFee());
            }
        } else if (this.level >= 15 && !this.farmerType.getFarmerTypeName().equals("Legendary Farmer")){
            if (choice == 1){
                this.farmerType.setFarmerTypeName("Legendary Farmer");
                this.farmerType.setBonusEarns(4);
                this.farmerType.setCostReduction(3);
                this.farmerType.setWaterIncrease(2);
                this.farmerType.setFertilizerIncrease(1);

                if (this.land.getPlantedSeed() != null && !this.land.getPlantedSeed().isWithered()){
                    this.land.getPlantedSeed().getWater().addWaterMax(this.farmerType.getWaterIncrease());
                    this.land.getPlantedSeed().getFertilizer().addFertilizerMax(this.farmerType.getFertilizerIncrease());
                }

                this.farmerType.setFee(400);
                this.gameStats.deductWallet(this.farmerType.getFee());
            }

        }
    }

    //GETTERS

    public FarmerType getFarmerType() {
        return farmerType;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getPassedDays() {
        return passedDays;
    }

    public Tile getLand() {
        return land;
    }

    public int getSelectedTool() {
        return selectedTool;
    }
}
