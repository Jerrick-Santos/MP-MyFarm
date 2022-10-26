package Game;

public class Pickaxe extends Tool{
    public Pickaxe(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public boolean useTool(Object obj) {
        boolean retVal;
        if (obj instanceof Tile) {
            Tile tile = (Tile) obj;
            if (tile.isRock()) {
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
