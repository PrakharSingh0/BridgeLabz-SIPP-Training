public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 1500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Aarav Mehta", "Sedan");
        Vehicle v2 = new Vehicle("Diya Kapoor", "Motorbike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(2000.0);
        v1.displayVehicleDetails(); // check the update reflected here too
    }
}