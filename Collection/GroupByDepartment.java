import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String dept) {
        this.name = name;
        this.department = dept;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static Map<String, List<Employee>> groupByDept(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, d -> new ArrayList<>()).add(e);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        Map<String, List<Employee>> grouped = groupByDept(emps);
        grouped.forEach((dept, list) -> System.out.println(dept + ": " + list));
    }
}