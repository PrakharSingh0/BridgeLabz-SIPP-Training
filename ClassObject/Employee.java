import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter ID: ");
        id = scanner.nextInt();
        System.out.print("Enter Salary: ");
        salary = scanner.nextDouble();
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee e=new Employee();
        e.inputDetails();
        e.displayDetails();
    }
}