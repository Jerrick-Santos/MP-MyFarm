package Game;

public abstract class Tool {
    private String name;
    private int cost;
    private double expGain;

    public Tool(String name, int cost, double expGain) {
        this.name = name;
        this.cost = cost;
        this.expGain = expGain;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getExpGain() {
        return expGain;
    }

    public abstract void useTool(Fertilizer fertilizer);
    public abstract void useTool(Water water);
    public abstract void useTool(Tile tile);

}
