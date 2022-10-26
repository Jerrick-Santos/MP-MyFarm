package Game;

public class FertilizerTool extends Tool{
    public FertilizerTool(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public boolean useTool(Object obj) {
        boolean retVal;
        if (obj instanceof Fertilizer){
            Fertilizer temp = (Fertilizer) obj;
            temp.addFertilizer();
            retVal = true;
        }
        else {
            retVal = false;
        }

        return retVal;
    }

}
