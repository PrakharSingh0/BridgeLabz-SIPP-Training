import java.util.Scanner;

public class Q23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter salary in INR: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter bonus in INR: ");
        double bonus = scanner.nextDouble();

        double totalIncome = salary + bonus;

        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus + ". Hence, the total income is INR " + totalIncome);

        scanner.close();
    }
}