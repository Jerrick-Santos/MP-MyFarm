package Game.Model.Tools;

import Game.Model.Controller.Tile;

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
     * @param tile - Takes tile as parameter
     * @return true if the tool can be used, false if not
     */
    @Override
    public boolean useTool(Tile tile) {
        boolean retVal;
            if (tile.getPlantedSeed() != null && tile.isPlowed() && !tile.getPlantedSeed().isWithered() && !tile.isRock()) //checks if the seed exists and tile is plowed
            {
                tile.getPlantedSeed().getWater().addWater(); //adds the water to the seed object
                retVal = true;
            }
            else {
                retVal = false;
                System.out.println("Warning: Plant not found.");
            }


        return retVal;
    }

}
