package Game.Model.Tools;
import Game.Model.Controller.Tile;

/**
 * This is the Tool class which is an abstract class. The purpose of this class is only to provide a template
 * or reusable code for its child classes such as the WaterCan, Fertilizer, Plow Tool, Pickaxe and Shovel.
 * This class also contains one abstract method which is how tools are individually used based on their different implementations.
 */

public abstract class Tool {
    private String name;
    private int cost;
    private double expGain;

    /**
     * Constructs the tool class.
     * @param name - name of the tool
     * @param cost - cost per use
     * @param expGain - exp gained when tool is used
     */
    public Tool(String name, int cost, double expGain) {
        this.name = name;
        this.cost = cost;
        this.expGain = expGain;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getExpGain() {
        return expGain;
    }

    /**
     * This method actually uses the tool based on their required functions and behaviours.
     * @param tile - the object taken input is a tile which will be used in the child classes
     * @return
     */
    public abstract boolean useTool(Tile tile);

}
