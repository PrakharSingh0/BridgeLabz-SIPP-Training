import java.util.*;
class Q3{
    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       double CM=sc.nextDouble();

       double res=CM/30.48; // 2.54*12
       
       int foot=(int) Math.floor(res);
       int inch=(int) Math.ceil(res);


       System.out.print("cm to Foot :");
       System.out.println(foot+"\""+inch+"\'");
    }
}