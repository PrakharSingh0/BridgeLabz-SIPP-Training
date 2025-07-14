public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int[] operationsCounts = {1000, 10000, 100000}; // Reduced 1,000,000 to 100,000 for practical execution

        System.out.println("String Concatenation Performance Comparison");
        System.out.println("------------------------------------------");

        for (int N : operationsCounts) {
            System.out.printf("Operations Count (N): %,d%n", N);

            // Using String
            long startTimeString = System.nanoTime();
            String str = "";
            for (int i = 0; i < N; i++) {
                str += "a";
            }
            long endTimeString = System.nanoTime();
            long durationString = (endTimeString - startTimeString) / 1_000_000; // milliseconds
            System.out.printf("  String (O(N^2)) Time: %d ms%n", durationString);

            // Using StringBuilder
            long startTimeStringBuilder = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append("a");
            }
            long endTimeStringBuilder = System.nanoTime();
            long durationStringBuilder = (endTimeStringBuilder - startTimeStringBuilder) / 1_000_000; // milliseconds
            System.out.printf("  StringBuilder (O(N)) Time: %d ms%n", durationStringBuilder);

            // Using StringBuffer
            long startTimeStringBuffer = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbf.append("a");
            }
            long endTimeStringBuffer = System.nanoTime();
            long durationStringBuffer = (endTimeStringBuffer - startTimeStringBuffer) / 1_000_000; // milliseconds
            System.out.printf("  StringBuffer (O(N)) Time: %d ms%n", durationStringBuffer);
            System.out.println();
        }

        System.out.println("Expected Result: StringBuilder & StringBuffer are much more efficient than String.");
        System.out.println("Use StringBuilder for single-threaded operations and StringBuffer for multi-threaded.");
    }
}