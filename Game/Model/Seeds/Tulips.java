package Game.Model.Seeds;

import Game.Model.FarmerTypes.FarmerType;

public class Tulips extends Seed{
    public Tulips(String name, String cropType, int harvestDayRequired, int waterMin, int waterMax, int fertilizerMin, int fertilizerMax, int seedCost, int productsProducedMin, int productsProducedMax, int baseSellingPrice, double expYield, FarmerType farmerType) {
        super(name, cropType, harvestDayRequired, waterMin, waterMax, fertilizerMin, fertilizerMax, seedCost, productsProducedMin, productsProducedMax, baseSellingPrice, expYield, farmerType);
    }

    @Override
    public double computeFinalPrice(FarmerType farmerType) {
        return super.computeFinalPrice(farmerType) * 1.1;
    }
}