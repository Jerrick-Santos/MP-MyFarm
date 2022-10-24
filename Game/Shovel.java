package Game;

public class Shovel extends Tool{

    public Shovel(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public void useTool(Object obj) {

    }

    @Override
    public void useTool(Fertilizer fertilizer) {

    }

    @Override
    public void useTool(Water water) {

    }

    @Override
    public void useTool(Tile tile) {

    }
}
