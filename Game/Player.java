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
            //this.land.getPlantedSeed().checkWithered();
        }
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
            if (select == 1){
                this.land.setPlantedSeed("Turnip", "Crop", 2, 0,
                        1,2,0,1,5,6,5);
                this.gameStats.deductWallet(5 - farmerType.getCostReduction());
            }
        }
        else {
            System.out.println("Warning: cannot be planted! selected tile is occupied");
        }
    }


}
