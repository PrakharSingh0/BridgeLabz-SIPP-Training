import java.util.Scanner;

public class SI {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int Principal=sc.nextInt();
        int Rate=sc.nextInt();
        int Time=sc.nextInt();
        System.out.print("SI :");
        System.out.println((Principal*Rate*Time)/100);
    }
}
