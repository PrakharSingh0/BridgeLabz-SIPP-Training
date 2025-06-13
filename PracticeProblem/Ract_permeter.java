import java.util.Scanner;

public class Ract_permeter {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int length=sc.nextInt();
        int width=sc.nextInt();
        System.out.print("Perimeter of Ractangle:");
        System.out.println(2*(length+width));
    }
}
