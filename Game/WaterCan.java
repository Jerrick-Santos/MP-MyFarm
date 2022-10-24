package Game;

public class WaterCan extends Tool{
    public WaterCan(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public void useTool(Object obj) {
        if (obj instanceof Water){
            Water temp = (Water) obj;
            temp.addWater();
        }
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
