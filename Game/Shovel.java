package Game;
/**
 * This class removes a seed (withered or not)
 */

public class Shovel extends Tool{
    /**
     * Constructs the Shovel class.
     * @param name - name of the tool
     * @param cost - cost per use
     * @param expGain - exp gained when tool is used
     */
    public Shovel(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    /**
     * removes a seed (withered or not)
     * @param obj - Takes tile as parameter
     * @return true if the tool can be used, false if not
     */
    @Override
    public boolean useTool(Object obj) {
        boolean retVal = false;
        if (obj instanceof Tile) {
            Tile tile = (Tile) obj;
            if (tile.isRock() || !tile.isPlowed()) { //checks if rock exists or tile is not plowed
                retVal = true;
            } else if (tile.isOccupied() && tile.getPlantedSeed() != null) { //checks if a plant exists
                retVal = true;
                tile.removePlantedSeed();
                tile.setPlowed(false);
                tile.setOccupied(false);
                System.out.println("GameChange: Plant has been removed");
            }
        }
        else {
            retVal = false;
        }

        return retVal;
    }

}
