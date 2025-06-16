import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year >= 1582) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                System.out.println(year + " is a Leap Year");
            else
                System.out.println(year + " is not a Leap Year");
        } else {
            System.out.println("Enter a year from 1582 onward.");
        }
    }
}