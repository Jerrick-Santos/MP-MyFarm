package Game;

import Game.Model.Controller.Player;
import Game.Model.Tools.*;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Tool PlowTool = new PlowTool("PlowTool", 0, 0.5);
        Tool WaterCan = new WaterCan("WaterCan", 0, 0.5);
        Tool FertilizerTool = new FertilizerTool("FertilizerTool", 10, 4);
        Tool Pickaxe = new Pickaxe("Pickaxe", 50, 15);
        Tool Shovel = new Shovel("Shovel", 7, 2);


        Scanner scanner = new Scanner(System.in);

        Player player = new Player(WaterCan, FertilizerTool, PlowTool, Pickaxe, Shovel);


        while (!player.endGame()){
            int selectMain, selectTool, selectPlant;
            int row, col, choice;
            double walletAdd, expAdd;

            displayMainActions();
            selectMain = scanner.nextInt();
            switch (selectMain) {
                case 0 -> {
                    displayToolOptions();
                    selectTool = scanner.nextInt();
                    player.equipTool(selectTool);
                }
                case 1 -> {
                    System.out.print("Enter Row: ");
                    row = scanner.nextInt();
                    System.out.print("Enter Col: ");
                    col = scanner.nextInt();
                    player.useEquippedTool(row, col);
                    if (player.updateLevel()){
                        if (player.checkFarmerTypeUpgradeEligibility()){
                            System.out.println("Note: Eligible for Farmer Type Upgrade");
                        }
                    }
                }
                case 2 -> player.nextDay();
                case 3 -> {
                    System.out.print("Enter Row: ");
                    row = scanner.nextInt();
                    System.out.print("Enter Col: ");
                    col = scanner.nextInt();
                    displayPlantSeedOptions();
                    selectPlant = scanner.nextInt();
                    player.plant(selectPlant, row, col);
                }
                case 4 -> {
                    System.out.print("Enter Row: ");
                    row = scanner.nextInt();
                    System.out.print("Enter Col: ");
                    col = scanner.nextInt();
                    player.harvestPlant(row, col);

                    if (player.updateLevel()){
                        if (player.checkFarmerTypeUpgradeEligibility()){
                            System.out.println("Note: Eligible for Farmer Type Upgrade");
                        }
                    }
                }
                case 5 -> {
                    System.out.print("Enter Row: ");
                    row = scanner.nextInt();
                    System.out.print("Enter Col: ");
                    col = scanner.nextInt();
                    displayPlayerStatus(player, row, col);
                }
                case 6 -> {
                    if (player.checkFarmerTypeUpgradeEligibility()){
                        System.out.print("Do You want to upgrade Farmer Type COST[" + player.getFarmerType().getFee() + "]: ");
                        choice = scanner.nextInt();

                        if (player.updateFarmerType(choice)){
                            System.out.println("Farmer Type Updated!");
                        }
                        else {
                            System.out.println("Farmer Type Update Denied!");
                        }
                    }
                    else{
                        System.out.println("Warning: You are not Eligible for Farmer Type Update!");
                    }
                }
                case 7 -> {
                    System.out.print("Enter Wallet Add: ");
                    walletAdd = scanner.nextDouble();
                    System.out.println("Enter Exp Add: ");
                    expAdd = scanner.nextDouble();
                    player.adminControl(walletAdd, expAdd);

                    if (player.updateLevel()){
                        if (player.checkFarmerTypeUpgradeEligibility()){
                            System.out.println("Note: Eligible for Farmer Type Upgrade");
                        }
                    }

                }
                case 8 -> {
                    player.restartGame();
                }
                case 9 -> {
                    player.endGameNow();
                }
            }
        }
    }

    public static void displayMainActions(){
        System.out.println("\n");
        System.out.println("==========================");
        System.out.println("Game Actions");
        System.out.println("[0] Equip a Tool");
        System.out.println("[1] Use Equipped Tool");
        System.out.println("[2] Proceed to Next Day");
        System.out.println("[3] Plant to Tile");
        System.out.println("[4] Harvest Plant");
        System.out.println("[5] Check Player Status");
        System.out.println("[6] Update Farmer Type");
        System.out.println("[7] Admin Controls");
        System.out.println("[8] Restart Game");
        System.out.println("[9] End Game");

        System.out.print("Enter an Action: ");
    }

    public static void displayPlayerStatus(Player p, int row, int col){
        System.out.println();
        System.out.println("====================================================");
        System.out.println("Level: " + p.getLevel());
        System.out.println("OBJC Wallet: " + p.getGameStats().getBalance());
        System.out.println("Experience (ExP): " + p.getGameStats().getExp());
        System.out.println("Passed Days: " + p.getPassedDays());
        System.out.println("Current Farmer Type: " + p.getFarmerType().getFarmerTypeName());

        if (p.getSelectedTool() != -1){
            if (p.getSelectedTool() == 0){
                System.out.println("Equipped Tool: Water Can");
            }
            else if (p.getSelectedTool() == 1){
                System.out.println("Equipped Tool: Fertilizer Tool");
            }
            else if (p.getSelectedTool() == 2){
                System.out.println("Equipped Tool: Plow Tool");
            }
            else if (p.getSelectedTool() == 3){
                System.out.println("Equipped Tool: Pickaxe");
            }
            else if (p.getSelectedTool() == 4){
                System.out.println("Equipped Tool: Shovel");
            }
        }
        else {
            System.out.println("Equipped Tool: None");
        }

        System.out.println("============");
        System.out.println("Tile Info: ");
        System.out.println("Rock Presence: " +  p.getLand(row,col).isRock());
        System.out.println("Plowed: " + p.getLand(row,col).isPlowed());
        System.out.println("Occupied: " + p.getLand(row,col).isOccupied());

        System.out.println("============");
        if (p.getLand(row,col).getPlantedSeed() != null){
            System.out.println("Planted Seed: " +
                    p.getLand(row,col).getPlantedSeed().getName());
            System.out.println("Withered: " +
                    p.getLand(row,col).getPlantedSeed().isWithered());
            System.out.println("Crop Maturity (in days): " +
                    p.getLand(row,col).getPlantedSeed().getDaysPassed());
            System.out.println("Harvest Day: " +
                    (p.getLand(row,col).getPlantedSeed().getHarvestDayRequired()));
            System.out.println("Maximum Water Requirement: " +
                    p.getLand(row,col).getPlantedSeed().getWater().getWaterMax());
            System.out.println("Minimum Water Requirement: " +
                    p.getLand(row,col).getPlantedSeed().getWater().getWaterMin());
            System.out.println("Times Crop Watered: " +
                    p.getLand(row,col).getPlantedSeed().getWater().getTimesCropWatered());
            System.out.println("Maximum Fertilizer Requirement: " +
                    p.getLand(row,col).getPlantedSeed().getFertilizer().getFertilizerMax());
            System.out.println("Minimum Fertilizer Requirement: " +
                    p.getLand(row,col).getPlantedSeed().getFertilizer().getFertilizerMin());
            System.out.println("Times Crop Fertilized: " +
                    p.getLand(row,col).getPlantedSeed().getFertilizer().getTimesCropFertilized());
        }
        else {
            System.out.println("Planted Seed: None");
        }

        System.out.println("====================================================");
        System.out.println();
    }

    public static void displayToolOptions(){
        System.out.println();
        System.out.println("==========================");
        System.out.println("Tool Options: ");
        System.out.println("[0] Water Can");
        System.out.println("[1] Fertilizer Tool");
        System.out.println("[2] Plow Tool");
        System.out.println("[3] Pickaxe");
        System.out.println("[4] Shovel ");
        System.out.print("Enter Tool Selection: ");
    }

    public static void displayPlantSeedOptions(){
        System.out.println();
        System.out.println("==========================");
        System.out.println("Note: When you decied to plant a seed. You will be " +
                "automatically buy a seed as well (deducting from your OBJCs Wallet");
        System.out.println("Seed Options: ");
        System.out.println("[0] Turnip - 5 OBJCs");
        System.out.println("[1] Carrot - 10 OBJCs");
        System.out.println("[2] Potato - 20 OBJCs");
        System.out.print("Enter Seed Selection: ");
    }
}
