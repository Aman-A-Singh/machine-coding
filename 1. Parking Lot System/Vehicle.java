enum VehicleType { CAR, BIKE, TRUCK }

public class Vehicle{
    String licensePlate;
    VehicleType type;
    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
}
class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
class Bike extends Vehicle{
    public Bike(String licensePlate) { 
        super(licensePlate, VehicleType.BIKE);
    }
}