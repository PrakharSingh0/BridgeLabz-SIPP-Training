class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void increaseSalary(double amount) {
        salary += amount;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {

    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showManagerInfo() {
        System.out.println("Manager ID: " + employeeID + ", Department: " + department + ", Salary: ₹" + getSalary());
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(5001, "Sales", 75000);
        mgr.increaseSalary(5000);
        mgr.showManagerInfo();
    }
}