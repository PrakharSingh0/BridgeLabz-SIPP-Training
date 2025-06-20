import java.util.Scanner;

public class ChocolateDivider {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = input.nextInt();
        System.out.print("Enter number of children: ");
        int children = input.nextInt();
        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[0] + " chocolates, Remaining: " + result[1]);
        input.close();
    }
}