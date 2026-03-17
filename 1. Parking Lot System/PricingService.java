public class PricingService {
    Double calculateAmount(Ticket ticket) {
        Long duration = System.currentTimeMillis() - ticket.getStartTime();
        Long hours = duration / (1000 * 60 * 60);
        CostStrategy costStrategy;
        switch (ticket.getVehicle().type) {
            case CAR:
                costStrategy = new CarCostStrategy();
                break;
            case BIKE:
                costStrategy = new BikeCostStrategy();
                break;
            default:
                costStrategy = null;
        }
        return costStrategy.calculateCost(Math.max(hours, 1));
    }
}
