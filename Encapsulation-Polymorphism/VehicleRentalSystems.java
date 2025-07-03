// Abstract class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
}

// Interface
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

// Car subclass
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rate) {
        super(vehicleNumber, "Car", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1500.0;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Car insurance: ₹1500 (fixed)");
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rate) {
        super(vehicleNumber, "Bike", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; // 10% discount on bikes
    }

    @Override
    public double calculateInsurance() {
        return 500.0;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Bike insurance: ₹500 (fixed)");
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rate) {
        super(vehicleNumber, "Truck", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000; // Additional fixed logistics fee
    }

    @Override
    public double calculateInsurance() {
        return 3000.0;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Truck insurance: ₹3000 (fixed)");
    }
}

// Main driver
public class VehicleRentalSystems {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("MH12AB1234", 2000),
            new Bike("DL5S2123", 500),
            new Truck("UP80CT9100", 4000)
        };

        int rentalDays = 5;

        for (Vehicle v : fleet) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            double rentalCost = v.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + rentalCost);

            if (v instanceof Insurable i) {
                double insurance = i.calculateInsurance();
                System.out.println("Insurance: ₹" + insurance);
                i.getInsuranceDetails();
            }

            System.out.println("----------------------------------");
        }
    }
}