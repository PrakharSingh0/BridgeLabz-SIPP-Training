// Abstract class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: ₹" + ratePerKm);
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
}

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Car Class
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String id, String name, double rate) {
        super(id, name, rate);
        this.location = "Garage";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Bike Class
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String id, String name, double rate) {
        super(id, name, rate);
        this.location = "Depot";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; // 10% discount
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Auto Class
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String id, String name, double rate) {
        super(id, name, rate);
        this.location = "Standby";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // ₹20 base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Driver class
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("C101", "Ramesh", 12),
            new Bike("B202", "Sita", 8),
            new Auto("A303", "Rahul", 10)
        };

        double tripDistance = 15.5;

        for (Vehicle v : fleet) {
            v.getVehicleDetails();
            double fare = v.calculateFare(tripDistance);
            System.out.println("Trip Distance: " + tripDistance + " km");
            System.out.println("Estimated Fare: ₹" + fare);

            if (v instanceof GPS gps) {
                gps.updateLocation("Sector 21");
                System.out.println("Updated Location: " + gps.getCurrentLocation());
            }

            System.out.println("------------------------------------");
        }
    }
}