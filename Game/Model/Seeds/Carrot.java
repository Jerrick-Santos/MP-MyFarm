package Game.Model.Seeds;

import Game.Model.FarmerTypes.FarmerType;

/**
 * Inherits the Seed class
 */
public class Carrot extends Seed{
    public Carrot(String name, String cropType, int harvestDayRequired, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax, int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield, FarmerType farmerType) {
        super(name, cropType, harvestDayRequired, waterMin, waterMax, fertilizerMin, fertilizerMax, seedCost, productsProducedMin, productsProducedMax, baseSellingPrice, expYield, farmerType);
    }
}
