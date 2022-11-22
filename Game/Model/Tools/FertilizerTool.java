package Game.Model.Tools;

import Game.Model.Controller.Tile;

/**
 * This class adds fertilizer to the seed
 */

public class FertilizerTool extends Tool{
    /**
     * Constructs the Fertilizer class.
     * @param name - name of the tool
     * @param cost - cost per use
     * @param expGain - exp gained when tool is used
     */
    public FertilizerTool(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    /**
     * adds fertilizer to the seed
     * @param tile - Takes tile as parameter
     * @return true if the tool can be used, false if not
     */
    @Override
    public boolean useTool(Tile tile) {
        boolean retVal;
            if (tile.getPlantedSeed() != null && tile.isPlowed() && !tile.getPlantedSeed().isWithered() && !tile.isRock()){ //checks if the seed exists and tile is plowed
                tile.getPlantedSeed().getFertilizer().addFertilizer(); //adds the fertilizer
                retVal = true;
            }
            else {
                retVal = false;
                System.out.println("Warning: Plant not found.");
            }

        return retVal;
    }

}
