package Game;

public class WaterCan extends Tool{
    public WaterCan(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public void useTool(Fertilizer fertilizer) {

    }

    @Override
    public void useTool(Water water) {
        water.addWater();
    }

    @Override
    public void useTool(Tile tile) {

    }
}
