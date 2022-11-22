package Game.Model.Tools;

import Game.Model.Controller.Tile;

/**
 * This class turns an unplowed tile to a plowed tile.
 */
public class PlowTool extends Tool{
    /**
     * Constructs the Plow class.
     * @param name - name of the tool
     * @param cost - cost per use
     * @param expGain - exp gained when tool is used
     */
    public PlowTool(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    /**
     * Turns the unplowed tile to a plowed tile
     * @param tile - Takes tile as parameter
     * @return true if the tool can be used, false if not
     */
    public boolean useTool(Tile tile) {
        boolean retVal = false;
            if (!tile.isPlowed() && !tile.isRock()) {
                tile.setPlowed(true);
                retVal = true;
                System.out.println("Note: Tile has been plowed");
            }
            else {
                retVal = false;
                System.out.println("Warning: Cannot use Plow Tool. Please check if tile has been plowed or occupied");
            }

        return retVal;
    }

}
