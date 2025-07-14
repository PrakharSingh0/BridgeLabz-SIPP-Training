public class FibonacciComputation {

    // Recursive Fibonacci Implementation (O(2^n))
    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci Implementation (O(N))
    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] fibonacciNValues = {10, 30, 40}; // Added 40 to show the difference more clearly, 50 is too large for recursive

        System.out.println("Fibonacci Computation Performance Comparison");
        System.out.println("------------------------------------------");

        for (int N : fibonacciNValues) {
            System.out.printf("Fibonacci (N): %,d%n", N);

            // Recursive Measurement
            long startTimeRecursive = System.nanoTime();
            long resultRecursive = 0;
            try {
                if (N <= 45) { // Limit N for recursive to avoid extremely long runtimes
                    resultRecursive = fibonacciRecursive(N);
                } else {
                    System.out.println("  Recursive: Skipped (N too large for practical recursive computation)");
                }
            } catch (StackOverflowError e) {
                System.out.println("  Recursive: Stack Overflow (N too large)");
            }
            long endTimeRecursive = System.nanoTime();
            long durationRecursive = (endTimeRecursive - startTimeRecursive) / 1_000_000; // milliseconds
            if (N <= 45) {
                System.out.printf("  Recursive (O(2^n)) Time: %d ms (Result: %d)%n", durationRecursive, resultRecursive);
            }

            // Iterative Measurement
            long startTimeIterative = System.nanoTime();
            long resultIterative = fibonacciIterative(N);
            long endTimeIterative = System.nanoTime();
            long durationIterative = (endTimeIterative - startTimeIterative) / 1_000_000; // milliseconds
            System.out.printf("  Iterative (O(N)) Time: %d ms (Result: %d)%n", durationIterative, resultIterative);
            System.out.println();
        }

        System.out.println("Expected Result: Recursive approach is infeasible for large values of N due to exponential growth.");
        System.out.println("The iterative approach is significantly faster and memory-efficient.");
    }
}