package Game;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hello!");
    }

    public static void displayMainActions(){
        System.out.println("Game Actions");
        System.out.println("[0] Equip a Tool");
        System.out.println("[1] Use Equipped Tool");
        System.out.println("[2] Proceed to Next Day");
        System.out.println("[3] Plant to Tile");
        System.out.println("[4] Harvest Plant");
        System.out.println("[5] Check Player Status");

        System.out.print("Enter an Action:");
    }

    public static void displayPlayerStatus(Player p){
        System.out.println("====================================================");
        System.out.println("Player Name: " + p.getName());
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
        System.out.println("Rock Presence: " +  p.getLand().isRock());
        System.out.println("Plowed: " + p.getLand().isPlowed());
        System.out.println("Occupied: " + p.getLand().isOccupied());

        System.out.println("============");
        if (p.getLand().getPlantedSeed() != null){
            System.out.println("Planted Seed: " +
                    p.getLand().getPlantedSeed().getName());
            System.out.println("Withered: " +
                    p.getLand().getPlantedSeed().isWithered());
            System.out.println("Crop Maturity (in days): " +
                    p.getLand().getPlantedSeed().getDaysPassed());
            System.out.println("Days Left Until Harvest Day: " +
                    (p.getLand().getPlantedSeed().getHarvestDayRequired() - p.getLand().getPlantedSeed().getDaysPassed()));
            System.out.println("Times Crop Watered: " +
                    p.getLand().getPlantedSeed().getWater().getTimesCropWatered());
            System.out.println("Times Crop Fertilized: " +
                    p.getLand().getPlantedSeed().getFertilizer().getTimesCropFertilized());
        }
        else {
            System.out.println("Planted Seed: None");
        }


    }

    public static void displayToolOptions(){
        System.out.println("Tool Options: ");
        System.out.println("[0] Water Can");
        System.out.println("[1] Fertilizer Tool");
        System.out.println("[2] Plow Tool");
        System.out.println("[3] Pickaxe");
        System.out.println("[4] Shovel ");
        System.out.print("Enter Tool Selection: ");
    }

    public static void displayPlantSeedOptions(){
        System.out.println("Note: When you decied to plant a seed. You will be " +
                "automatically buy a seed as well (deducting from your OBJCs Wallet");
        System.out.println("Seed Options: ");
        System.out.println("[0] Turnip - 5 OBJCs");
        System.out.println("[1] Carrot - 10 OBJCs");
        System.out.println("[2] Potato - 20 OBJCs");
        System.out.print("Enter Seed Selection: ");
    }
}
