package Game;

public class WaterCan extends Tool{
    public WaterCan(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public boolean useTool(Object obj) {
        boolean retVal;
        if (obj instanceof Tile){
            Tile temp = (Tile) obj;

            if (temp.getPlantedSeed() != null && temp.isPlowed() && !temp.getPlantedSeed().isWithered()
            ){
                temp.getPlantedSeed().getWater().addWater();
                retVal = true;
            }
            else {
                retVal = false;
                System.out.println("Warning: Plant not found. Please plant a seed first.");
            }

        }
        else {
            retVal = false;
        }

        return retVal;
    }

}
