package Game;

public class WaterCan extends Tool{
    public WaterCan(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public boolean useTool(Object obj) {
        boolean retVal;
        if (obj instanceof Water){
            Water temp = (Water) obj;
            temp.addWater();
            retVal = true;
        }
        else {
            retVal = false;
        }

        return retVal;
    }

}
