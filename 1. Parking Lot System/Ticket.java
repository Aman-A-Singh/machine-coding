public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private long startTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.startTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getparkingSpot() {
        return parkingSpot;
    }

    public long getStartTime() {
        return startTime;
    }

}
