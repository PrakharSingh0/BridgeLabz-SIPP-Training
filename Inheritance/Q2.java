class Device {
    String deviceId;
    boolean status;

    Device(String id, boolean status) {
        this.deviceId = id;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + (status ? "On" : "Off"));
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String id, boolean status, double temp) {
        super(id, status);
        this.temperatureSetting = temp;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature: " + temperatureSetting + "°C");
    }

    public static void main(String[] args) {
        Thermostat t = new Thermostat("T1001", true, 24.5);
        t.displayStatus();
    }
}