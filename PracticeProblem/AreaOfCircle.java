import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int radius=sc.nextInt();
        
        System.out.print("Area: ");
        System.out.println(3.14*radius*radius);
    }
}
