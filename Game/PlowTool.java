package Game;

public class PlowTool extends Tool{
    public PlowTool(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    public boolean useTool(Object obj) {
        boolean retVal = false;
        if (obj instanceof Tile) {
            Tile tile = (Tile) obj;
            if (!tile.isPlowed()) {
                tile.setPlowed(true);
                retVal = true;
                System.out.println("Note: Tile has been plowed");
            }
            else {
                retVal = false;
                System.out.println("Warning: Cannot use Plow Tool - Tile is already plowed.");
            }
        }
        else {
            retVal = false;
        }

        return retVal;
    }

}
