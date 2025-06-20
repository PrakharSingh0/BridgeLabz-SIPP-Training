public class FactorMath {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0; for (int v : arr) s += v;
        return s;
    }

    public static long product(int[] arr) {
        long prod = 1; for (int v : arr) prod *= v;
        return prod;
    }

    public static double cubeProduct(int[] arr) {
        double prod = 1;
        for (int v : arr) prod *= Math.pow(v, 3);
        return prod;
    }

    public static int greatestFactor(int[] arr) {
        return arr[arr.length - 1]; // sorted by definition
    }

    public static void main(String[] args) {
        int n = 12;
        int[] factors = getFactors(n);
        System.out.print("Factors of " + n + ": ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nSum: " + sum(factors));
        System.out.println("Product: " + product(factors));
        System.out.println("Cube Product: " + cubeProduct(factors));
        System.out.println("Greatest Factor: " + greatestFactor(factors));
    }
}