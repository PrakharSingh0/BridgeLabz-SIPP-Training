class Book{
    public String bookName;
    public String bookAuthor;
    public int bookPrice;
    
    Book(){
        bookName="Default Book";
        bookAuthor="Default Auther";
        bookPrice=0;
    }

    Book(String bookName,String autherName,int price){
        this.bookName=bookName;
        this.bookAuthor=autherName;
        this.bookPrice=price;
    }

    void DisplayOutput(){
        System.out.println("Book Name :"+bookName);
        System.out.println("Book Auther Name :"+bookAuthor);
        System.out.println("Book Price:"+bookPrice);
    }

    public static void main(String[] args) {
        Book b=new Book();
        b.DisplayOutput();
       
        Book b1=new Book("Java Fundamentals","someone",500);
        b1.DisplayOutput();
    }

}