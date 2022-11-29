package Game;

import Game.Model.Controller.Player;
import Game.Model.Controller.Tile;
import Game.Model.Tools.*;
import Game.View.MyFarmGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
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
        updateView();
        row = 0;
        col = 0;
        updateTileInfo(this.row, this.col);
        mainGUI.setActionListener(this);
    }

    public void updateView(){
        mainGUI.setFarmerTypeName(player.getFarmerType().getFarmerTypeName());
        mainGUI.setFarmerLevel(player.getLevel());
        mainGUI.setFarmerBalance(player.getGameStats().balance);
        mainGUI.setFarmerExpVal(player.getGameStats().exp);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied()){ //if there is a rock
                    mainGUI.rockOccupied(i,j);
                }
                else if (!player.getLand(i,j).isRock() && !player.getLand(i,j).isOccupied() &&
                        player.getLand(i,j).isPlowed()){ //if a tile i plowed
                    mainGUI.plowedTile(i,j);
                }
                else if (!player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied() && player.getLand(i,j).isPlowed()
                && player.getLand(i,j).isPlowed() && player.getLand(i,j).getPlantedSeed() != null && player.getLand(i,j).getPlantedSeed().isWithered()){ //if a plant has withered
                    mainGUI.plantWithered(i,j);
                }
                else if (player.checkHarvestPlantEligiility(i,j)){ //if a plant is ready for harvest
                    mainGUI.readyForHarvest(i,j);
                }
                else if (!player.getLand(i,j).isRock() && player.getLand(i,j).isOccupied()){ //if occupied with a plant
                    mainGUI.tileIsOccupied(i,j);
                }
                else {
                    mainGUI.revertOriginalTileColor(i,j);
                }
            }
        }

        if (player.updateLevel()){
            mainGUI.setFarmerLevel(player.getLevel());
            mainGUI.displayLevelUp(player.getLevel());
            if (player.checkFarmerTypeUpgradeEligibility()){
                mainGUI.displayFarmerUpgradeEligibility();
            }
        }

    }

    public void updateTileInfo(int row, int col){
        if (player.getLand(row,col).getPlantedSeed() != null){
            mainGUI.setCropM(player.getLand(row,col).getPlantedSeed().getDaysPassed());
            mainGUI.setHarvestD(player.getLand(row,col).getPlantedSeed().getHarvestDayRequired());
            //TODO: Maximum WR
            mainGUI.setMinWR(player.getLand(row,col).getPlantedSeed().getWater().getWaterMin());
            mainGUI.setTimesCW(player.getLand(row,col).getPlantedSeed().getWater().getTimesCropWatered());
            //TODO: MAXIMUM FR
            mainGUI.setMinFR(player.getLand(row,col).getPlantedSeed().getFertilizer().getFertilizerMin());
            mainGUI.setTimesCF(player.getLand(row,col).getPlantedSeed().getFertilizer().getTimesCropFertilized());
            mainGUI.revertTileInfo();
            mainGUI.setPlantLabel(player.getLand(this.row, this.col).getPlantedSeed().getName());

        } else if (player.getLand(row,col).getPlantedSeed() == null){
            mainGUI.removeAllTileInfo();
            mainGUI.setPlantLabel("None");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Watercan")) {
            mainGUI.changeToolButtonColor(0,player.getSelectedTool());
            player.equipTool(0);
            System.out.println("0");
        }
        else if (e.getActionCommand().equals("Fertilizer")){
            mainGUI.changeToolButtonColor(1,player.getSelectedTool());
            player.equipTool(1);
        }
        else if (e.getActionCommand().equals("Plow Tool")){
            mainGUI.changeToolButtonColor(2,player.getSelectedTool());
            player.equipTool(2);
        }
        else if (e.getActionCommand().equals("Pickaxe")){
            mainGUI.changeToolButtonColor(3,player.getSelectedTool());
            player.equipTool(3);
        }
        else if (e.getActionCommand().equals("Shovel")){
            mainGUI.changeToolButtonColor(4,player.getSelectedTool());
            player.equipTool(4);
        }
        else if (e.getActionCommand().equals("Plant")){
            int select = mainGUI.displaySeedOptions();
            player.plant(select, this.row, this.col);
            updateView();
            updateTileInfo(this.row, this.col);
        }
        else if (e.getActionCommand().equals("Harvest")){
            player.harvestPlant(this.row, this.col);
            updateView();
            updateTileInfo(this.row, this.col);
        }
        else if (e.getActionCommand().equals("Next Day")){
            player.nextDay();
            updateTileInfo(this.row, this.col);
            updateView();
        }
        else if (e.getActionCommand().equals("Use Tool")){
            player.useEquippedTool(this.row,this.col);
            updateView();
            updateTileInfo(this.row, this.col);
        }
        else if (e.getActionCommand().equals("Prestige Up")){
            if (player.checkFarmerTypeUpgradeEligibility()){
                int choice = mainGUI.displayFarmerTypeUpgradeOptions(player.getNextFarmerType().getFarmerTypeName(), player.getNextFarmerType().getFee());
                System.out.println(choice);
                player.updateFarmerType(choice);
            }
            else{
                mainGUI.displayFarmerError();
            }
            updateView();
            updateTileInfo(this.row, this.col);
        }
        else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                  String entry = i + "," + j;
                    if (e.getActionCommand().equals(entry)){
                        if (e.getSource() instanceof JButton) {
                            String text = ((JButton) e.getSource()).getText();
                            String[] arrStr = text.split(",",2);
                            this.row = Integer.parseInt(arrStr[0]);
                            this.col = Integer.parseInt(arrStr[1]);
                            mainGUI.setPlantCoordinate(text);
                            updateTileInfo(this.row,this.col);
                        }
                    }
                }
            }
        }

    }

}
