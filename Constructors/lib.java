import java.util.*;

public class lib {

    public String title;
    public String Auther;
    public String price;
    protected boolean available;
    protected String BorrowedBy;

    lib(String tittle,String auther,String price,boolean avail,String borrow){
        this.title=tittle;
        this.Auther=auther;
        this.price=price;
        this.available=avail;
        this.BorrowedBy=borrow;
    }

    void displayDetails(){
        System.err.println("Tittle :"+title);
        System.err.println("Auther :"+Auther);
        System.err.println("Price :"+price);
        System.err.println("Available :"+available);
        System.err.println("Borrowed By :"+BorrowedBy);

    }

    void BorrowBook(String Name){
        if(!available){
           this.BorrowedBy=Name;
           this.available=false;
        }
        else{
            System.out.println("Book is not Available to Borrow");
        }
    }

    void showBorrower(){
        System.out.println("Borrowed By :"+BorrowedBy);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        lib l=new lib("C fundamental", "Myself", "1000", false, "");
        System.err.println("Book Details : -");
        l.displayDetails();
        
        System.out.println();
        
        
        System.out.println("Enter Name to Borrow :");
        String Name=sc.nextLine();
        l.BorrowBook(Name);

        l.showBorrower();
    }
}
