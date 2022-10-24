package Game;

public class Pickaxe extends Tool{
    public Pickaxe(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public void useTool(Object obj) {
        if (obj instanceof Tile) {
            Tile tile = (Tile) obj;
            if (tile.isRock()) {
                tile.setRock(false);
            }
            else {
                System.out.println("Warning: Cannot use Pickaxe - rock is not available");
            }
        }
    }

    @Override
    public void useTool(Fertilizer fertilizer) {
    }

    @Override
    public void useTool(Water water) {

    }

    @Override
    public void useTool(Tile tile) {
        if (tile.isRock()) {
            tile.setRock(false);
        }
        else {
            System.out.println("Warning: Cannot use Pickaxe - rock is not available");
        }
    }
}
