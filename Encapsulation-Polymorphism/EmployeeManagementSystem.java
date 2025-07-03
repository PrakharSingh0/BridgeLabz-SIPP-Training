// Abstract class
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
    }

    // Getters and setters
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
}

// Interface
interface Department {
    void assignDepartment(String deptName);
    void getDepartmentDetails();
}

// FullTime subclass
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }

    @Override
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }
}

// PartTime subclass
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0); // baseSalary not used for part-time
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Bob", 300, 20);

        Department dept1 = (Department) emp1;
        Department dept2 = (Department) emp2;

        dept1.assignDepartment("Finance");
        dept2.assignDepartment("Support");

        Employee[] employees = {emp1, emp2};
        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("Salary: " + e.calculateSalary());
            if (e instanceof Department d) d.getDepartmentDetails();
            System.out.println();
        }
    }
}