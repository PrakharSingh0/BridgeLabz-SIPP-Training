import java.util.Scanner;
import java.math.*;

public class PowerCal {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        int exp=sc.nextInt();
        System.out.print(num+"^"+exp+": ");
        System.out.println(Math.pow(num, exp));
    }
}
