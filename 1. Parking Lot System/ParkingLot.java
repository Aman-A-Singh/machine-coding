import java.util.List;

public class ParkingLot {
    private List<Level> levels;

    private ParkingLot(List<Level> levels) {
        this.levels = levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            ParkingSpot spot = level.findAndOccupySpot(vehicle);
            if (spot != null) {
                String ticketId = "TKT-" + System.currentTimeMillis();
                return new Ticket(ticketId, vehicle, spot);
            }
        }
        System.out.println("Sorry, Lot is Full for ${vehicle.type}");
        return null;
    }

    public boolean unparkVehicle(Ticket ticket) {
        for (Level level : levels) {
            if (level.unparkVehicle(ticket)) {
                return true;
            }
        }
        return false;
    }

}
