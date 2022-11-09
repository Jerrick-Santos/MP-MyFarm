package Game.Model.Tools;

import Game.Model.Controller.Tile;

/**
 * This class removes a rock
 */
public class Pickaxe extends Tool{
    /**
     * Constructs the Pickaxe class.
     * @param name - name of the tool
     * @param cost - cost per use
     * @param expGain - exp gained when tool is used
     */
    public Pickaxe(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    /**
     * removes a rock
     * @param obj - the object taken input is a tile which will be used in the child classes
     * @return true if the tool can be used, false if not
     */
    @Override
    public boolean useTool(Object obj) {
        boolean retVal;
        if (obj instanceof Tile) {
            Tile tile = (Tile) obj;
            if (tile.isRock()) { //checks if there is a rock
                tile.setRock(false);
                retVal = true;
            }
            else {
                retVal = false;
                System.out.println("Warning: Cannot use Pickaxe - rock is not present");
            }
        }
        else {
            retVal = false;
        }

        return retVal;
    }


}
