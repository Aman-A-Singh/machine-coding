import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot{
    String id;
    VehicleType type;
    private AtomicBoolean isOccupied = new AtomicBoolean(false);

    Boolean tryOccupy(){
        return isOccupied.compareAndSet(false, true);
    }

    Boolean release(){
        return isOccupied.compareAndSet(true, false);
    }
}