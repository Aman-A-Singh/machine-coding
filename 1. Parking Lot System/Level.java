import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Level {
    private final int floor;
    private final List<ParkingSpot> spots;
    private AtomicInteger availableSpots = new AtomicInteger(0);

    public Level(int floor, int numSpots) {
        this.floor = floor;
        this.spots = new ArrayList<>();
        for (int i = 0; i < numSpots; i++) {
            spots.add(new ParkingSpot());
        }
    }

    public int getFloor() {
        return floor;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public ParkingSpot findAndOccupySpot(Vehicle vehicle) {
        if (availableSpots.get() <= 0 || !tryDecrement()) {
            return null;
        }
        ParkingSpot parkingSpot = spots.stream()
                .filter(spot -> spot.type == vehicle.type)
                .filter(spot -> spot.tryOccupy())
                .findFirst()
                .orElse(null);

        if (parkingSpot == null) {
            availableSpots.incrementAndGet();
        }

        return parkingSpot;
    }

    private Boolean tryDecrement() {
        while (true) {
            int current = availableSpots.get();
            if (current <= 0)
                return false;
            if (availableSpots.compareAndSet(current, current - 1))
                return true;
        }
    }

    Boolean unparkVehicle(Ticket ticket) {
        ParkingSpot spot = ticket.getparkingSpot();

        // 1. Defensive Check: Only unpark if the spot is currently taken
        if (spot.release()) {
            // 2. Only if the spot was successfully cleared,
            // we let the next car into the level.
            availableSpots.incrementAndGet();
            return true;
        }
        return false;
    }
}