import java.util.Random;

public class RandomStats {
    public static int[] generate4DigitRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = 1000 + rand.nextInt(9000);
        }
        return array;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0, min = numbers[0], max = numbers[0];
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new double[]{sum / (double)numbers.length, min, max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        double[] stats = findAverageMinMax(randomNumbers);
        System.out.print("Generated: ");
        for (int n : randomNumbers) System.out.print(n + " ");
        System.out.println("\nAverage: " + stats[0] + ", Min: " + stats[1] + ", Max: " + stats[2]);
    }
}