package Game;

/**
 * This class adds water to the seed
 */

public class WaterCan extends Tool{
    /**
     * Constructs the Watercan class.
     * @param name - name of the tool
     * @param cost - cost per use
     * @param expGain - exp gained when tool is used
     */
    public WaterCan(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    /**
     * adds water to the seed
     * @param obj - Takes tile as parameter
     * @return true if the tool can be used, false if not
     */
    @Override
    public boolean useTool(Object obj) {
        boolean retVal;
        if (obj instanceof Tile){
            Tile temp = (Tile) obj;

            if (temp.getPlantedSeed() != null && temp.isPlowed() && !temp.getPlantedSeed().isWithered() //checks if the seed exists and tile is plowed
            ){
                temp.getPlantedSeed().getWater().addWater(); //adds the water to the seed object
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
