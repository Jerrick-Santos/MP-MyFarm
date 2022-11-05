package Game;
/**
 * This is the Player class which handles all the game mechanics. It is also responsible for instantiating
 * the required classes to rune the game (e.g., Tile). The player class holds the necessary attributes to perform
 * game mechanics such as to plant, harvest, equip a tool, use a tool and proceed to next day.
 */

import Game.Tool;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private String name;
    private int level;
    private int passedDays;
    private FarmerType farmerType;
    private GameStats gameStats;
    private Tile[][] land;
    private ArrayList<Tool> toolSetList;
    private int selectedTool;

    /**
     * This constructor creates the game itself. Creates the required classes needed for the game to run.
     * @param name - the name of the player
     * @param tool1 - Water can
     * @param tool2 - Fertilizer
     * @param tool3 - Plow Tool
     * @param tool4 - Pickaxe
     * @param tool5 - Shovel
     */
    public Player(String name, Tool tool1, Tool tool2, Tool tool3, Tool tool4, Tool tool5) {
        this.name = name;
        this.level = 0;
        this.passedDays = 0;
        this.farmerType = new FarmerType();
        this.gameStats = new GameStats();
        this.land = new Tile[10][5];
        this.toolSetList = new ArrayList<>(Arrays.asList(tool1, tool2, tool3, tool4, tool5)); //takes input from pre-constructed tool variables in main
        this.selectedTool = -1;
    }

    /**
     * checks if certain requirements has been met to end the game. I.e., checking the balance and withered seed(s)
     * @return true if game has ended, otherwise return false
     */
    public boolean endGame(){ //currently only works on a single tile
        boolean retVal = false;
        int tilesWithWitheredSeed = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.land[i][j].getPlantedSeed() != null && this.land[i][j].getPlantedSeed().isWithered()){
                    tilesWithWitheredSeed++;
                }
            }
        }

        if ((tilesWithWitheredSeed == 50 && this.gameStats.getBalance() < 3) || tilesWithWitheredSeed == 50){
            retVal = true;
        }

        return retVal;
    }

    /**
     * Proceeds to the next day when method is called
     * Adds a passed day in the plane (seed) if it exists, if not it will not do anything
     * Nevertheless, it will always increment the passedDays attribute within player
     */
    public void nextDay(){

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.land[i][j].getPlantedSeed() != null && this.land[i][j].isPlowed()){
                    this.land[i][j].getPlantedSeed().addDaysPassed();
                    this.land[i][j].getPlantedSeed().checkWithered();
                }
            }
        }
        this.passedDays++;
        System.out.println("Passed Days: " + this.passedDays);
    }

    /**
     * Equips a tool from the toolSetList ArrayList
     * @param toolIndex - User input given their tool of choice
     */
    public void equipTool(int toolIndex){
        if (toolIndex >= 0 && toolIndex < 5){
            this.selectedTool = toolIndex;
        }
        else{
            System.out.println("Warning: Invalid Tool Selection");
        }
    }

    /**
     * Plants the seed to the tile given their selection. Each plant type is represented by a number(int).
     * A plant can only be planted with the correct usage of select, there is no presence of rock, the tile is
     * plowed, not occupied, there is no presence of planted plant (seed), and finally not occupied.
     * When these conditions are met then, the OBJCs wallet will be deducted automatically to the appropriate amount.
     * @param select - User input given their seed of choice
     */
    public boolean plant(int select, int row, int col){
        boolean retVal = false;
        if (this.land[row][col].isPlowed() && !this.land[row][col].isOccupied()
        && this.land[row][col].getPlantedSeed() == null && !this.land[row][col].isRock())
        {
            if (select == 0 && this.gameStats.getBalance() >= 5 - farmerType.getCostReduction()){
                this.land[row][col].setPlantedSeed("Turnip", "Root Crop", 2,
                        1,2,
                        0,1,
                        5,
                        1,2,
                        6,5, this.farmerType);
                System.out.println("Note: Turnip planted!");
                this.gameStats.deductWallet(5 - farmerType.getCostReduction());
                retVal = true;
            }
            else if (select == 1 && this.gameStats.getBalance() >= 10 - farmerType.getCostReduction()){
                this.land[row][col].setPlantedSeed("Carrot", "Root Crop", 3,
                        1,2,
                        0,1,
                        10,
                        1,2,
                        9,7.5, this.farmerType);
                System.out.println("Note: Carrot planted!");
                this.gameStats.deductWallet(10 - farmerType.getCostReduction());
                retVal = true;
            }
            else if (select == 2 && this.gameStats.getBalance() >= 20 - farmerType.getCostReduction()){
                this.land[row][col].setPlantedSeed("Potato", "Root Crop", 5,
                        3,4,
                        1,2,
                        20,
                        1,10,
                        3,12.5, this.farmerType);
                System.out.println("Note: Potato planted!");
                this.gameStats.deductWallet(20 - farmerType.getCostReduction());
                retVal = true;
            }
            else{
                System.out.println("Warning: Insufficient OBJCs to buy chosen seed!");
            }
        }
        else if (this.land[row][col].isPlowed() && this.land[row][col].isOccupied()
                && this.land[row][col].getPlantedSeed() != null){
            System.out.println("Warning: cannot be planted! - Tile still has a plant");
        }
        else {
            System.out.println("Warning: cannot be planted! - Tile is not plowed");
        }

        return retVal;
    }


    /**
     * Harvests a plant.
     * When this method is called, it checks if there is a seed planted, the tile is plowed and not withered.
     * It also checks if the planted seed has reached its harvest day.
     * If these conditions are met, the tile is reverted to its original state and appropriate calculations
     * of the computed price will be added to the OBJCs wallet.
     */
    public boolean harvestPlant(int row, int col) {
        boolean retVal = false;
        if (this.land[row][col].getPlantedSeed() != null && this.land[row][col].isPlowed()
            && !this.land[row][col].getPlantedSeed().isWithered()
            && this.land[row][col].getPlantedSeed().getHarvestDayRequired() == this.land[row][col].getPlantedSeed().getDaysPassed()){
            System.out.println(this.land[row][col].getPlantedSeed().getName() + " has been harvested.");
            this.gameStats.addWallet(this.land[row][col].getPlantedSeed().computeFinalPrice(this.farmerType));
            this.gameStats.gainExp(this.land[row][col].getPlantedSeed().getExpYield());
            this.land[row][col].removePlantedSeed();
            this.land[row][col].setOccupied(false);
            this.land[row][col].setPlowed(false);
            retVal = true;
        }
        else if (this.land[row][col].getPlantedSeed() != null && this.land[row][col].isPlowed()
            && this.land[row][col].getPlantedSeed().isWithered()){
            System.out.println("Warning: Plant is withered! Use the shovel!");
        }
        else if (this.land[row][col].getPlantedSeed() != null && this.land[row][col].isPlowed()
                && !this.land[row][col].getPlantedSeed().isWithered()
                && this.land[row][col].getPlantedSeed().getHarvestDayRequired() != this.land[row][col].getPlantedSeed().getDaysPassed()){
            System.out.println("Warning: Harvest Day Required not met.");
        }
        else {
            System.out.println("Warning: Plant does not exist. Please plant a seed");
        }
        return retVal;
    }

    /**
     * Uses the selected tool by using the selectedTool attribute.
     * EXP will be added when the tool can be successfully used.
     */
    public boolean useEquippedTool(int row, int col){
        boolean retVal = false;
        if (this.selectedTool != -1){
            if (this.selectedTool == 0){ //WaterCan
                if (this.toolSetList.get(selectedTool).useTool(this.land[row][col])){
                    this.gameStats.gainExp(0.5);
                    retVal = true;
                }
            }
            else if (this.selectedTool == 1 && this.gameStats.getBalance() >= 10){ //fertilizer
                if (this.toolSetList.get(selectedTool).useTool(this.land[row][col])){
                    this.gameStats.gainExp(4);
                    this.gameStats.deductWallet(10);
                    retVal = true;
                }
            }
            else if (this.selectedTool == 2){ //Plow
                if (this.toolSetList.get(selectedTool).useTool(this.land[row][col])){
                    this.gameStats.gainExp(0.5);
                    retVal = true;
                }
            }
            else if (this.selectedTool == 3 && this.gameStats.getBalance() >= 50){ //Pickaxe
                if (this.toolSetList.get(selectedTool).useTool(this.land[row][col])){
                    this.gameStats.gainExp(15);
                    this.gameStats.deductWallet(50);
                    retVal = true;
                }
            }
            else if (this.selectedTool == 4 && this.gameStats.getBalance() >= 7){ //Shovel
                if (this.toolSetList.get(selectedTool).useTool(this.land[row][col])){
                    this.gameStats.gainExp(2);
                    this.gameStats.deductWallet(7);
                    retVal = true;
                }
            }
            else {
                System.out.println("Cannot use tool: Conditions are not met");
            }
        }
        else {
            System.out.println("Warning: Tool not Equipped.");
        }

        return retVal;
    }

    /**
     * Checks the requirements (EXP) if the player can level up. Increments the level by 1 when conditions are met.
     * @return true if the level has been updated
     */
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

    /**
     * Upgrades the farmer type parameters (bonuses and seed cost reduction)
     * @param choice - 1 (yes) or 0 (no) to decide if user wished to upgrade the farmerType
     */
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

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (this.land[i][j].getPlantedSeed() != null && !this.land[i][j].getPlantedSeed().isWithered()){
                            this.land[i][j].getPlantedSeed().getWater().addWaterMax(this.farmerType.getWaterIncrease());
                        }
                    }
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

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (this.land[i][j].getPlantedSeed() != null && !this.land[i][j].getPlantedSeed().isWithered()){
                            this.land[i][j].getPlantedSeed().getWater().addWaterMax(this.farmerType.getWaterIncrease());
                            this.land[i][j].getPlantedSeed().getFertilizer().addFertilizerMax(this.farmerType.getFertilizerIncrease());
                        }
                    }
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

    public Tile getLand(int row, int col) {
        return land[row][col];
    }

    public int getSelectedTool() {
        return selectedTool;
    }
}
