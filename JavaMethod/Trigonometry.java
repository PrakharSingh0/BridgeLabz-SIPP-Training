public class Trigonometry {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{
            Math.sin(radians),
            Math.cos(radians),
            Math.tan(radians)
        };
    }

    public static void main(String[] args) {
        double angle = 45.0; // Example angle
        double[] results = calculateTrigonometricFunctions(angle);
        System.out.println("Sin: " + results[0] + ", Cos: " + results[1] + ", Tan: " + results[2]);
    }
}