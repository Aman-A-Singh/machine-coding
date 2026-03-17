interface CostStrategy {
    Double calculateCost(Long hours);
}

class CarCostStrategy implements CostStrategy {
    @Override
    public Double calculateCost(Long hours) {
        return hours * 50.0;
    }
}

class BikeCostStrategy implements CostStrategy {
    @Override
    public Double calculateCost(Long hours) {
        return hours * 20.0;
    }
}