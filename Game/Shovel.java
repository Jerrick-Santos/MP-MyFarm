package Game;

public class Shovel extends Tool{

    public Shovel(String name, int cost, double expGain) {
        super(name, cost, expGain);
    }

    @Override
    public boolean useTool(Object obj) {
        boolean retVal = false;
        if (obj instanceof Tile) {
            Tile tile = (Tile) obj;
            if (tile.isRock() || !tile.isPlowed()) {
                retVal = true;
            } else if (tile.isOccupied() && tile.getPlantedSeed() != null) {
                retVal = true;
                tile.removePlantedSeed();
                tile.setPlowed(false);
                tile.setOccupied(false);
                System.out.println("GameChange: Plant has been removed");
            }
        }
        else {
            retVal = false;
        }

        return retVal;
    }

}
