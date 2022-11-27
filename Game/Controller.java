package Game;

import Game.Model.Controller.Player;
import Game.Model.Controller.Tile;
import Game.Model.Tools.*;
import Game.View.MyFarmGUI;

public class Controller {
    private Tool PlowTool;
    private Tool WaterCan;
    private Tool FertilizerTool;
    private Tool Pickaxe;
    private Tool Shovel;
    private Player player;
    private MyFarmGUI mainGUI;
    private int row;
    private int col;

    public Controller() {
        PlowTool = new PlowTool("PlowTool", 0, 0.5);
        WaterCan = new WaterCan("WaterCan", 0, 0.5);
        FertilizerTool = new FertilizerTool("FertilizerTool", 10, 4);
        Pickaxe = new Pickaxe("Pickaxe", 50, 15);
        Shovel = new Shovel("Shovel", 7, 2);
        player = new Player(WaterCan, FertilizerTool, PlowTool, Pickaxe, Shovel);
        mainGUI = new MyFarmGUI();
        row = 0;
        col = 0;
    }

    public void updateView(){
        mainGUI.setFarmerTypeName(player.getFarmerType().getFarmerTypeName());
        mainGUI.setFarmerBalance(player.getGameStats().balance);
        mainGUI.setFarmerExpVal(player.getGameStats().exp);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied()){ //if there is a rock
                    mainGUI.rockOccupied(i,j);
                }
                else if (!player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied()){ //if occupied with a plant
                    mainGUI.tileIsOccupied(i,j);
                }
                else if (!player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied() && player.getLand(i,j).isPlowed()
                && player.getLand(i,j).isPlowed() && player.getLand(i,j).getPlantedSeed() != null && player.getLand(i,j).getPlantedSeed().isWithered()){ //if a plant has withered
                    mainGUI.plantWithered(i,j);
                }
                else if (player.harvestPlant(i,j)){ //if a plant is ready for harvest
                    mainGUI.readyForHarvest(i,j);
                }
            }
        }
    }

}
