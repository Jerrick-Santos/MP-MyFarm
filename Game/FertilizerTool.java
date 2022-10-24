package Game;

public class FertilizerTool extends Tool{
    public FertilizerTool(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public void useTool(Fertilizer fertilizer) {
        fertilizer.addFertilizer();
    }

    @Override
    public void useTool(Water water) {

    }

    @Override
    public void useTool(Tile tile) {

    }
}
