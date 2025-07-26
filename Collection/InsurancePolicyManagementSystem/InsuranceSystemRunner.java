package InsurancePolicyManagementSystem;

import java.time.LocalDate;

public class InsuranceSystemRunner {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 1200));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 1500));
        manager.addPolicy(new InsurancePolicy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 1000));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 1500)); // Duplicate

        System.out.println("=== All Policies ===");
        manager.printAllUnique();

        System.out.println("\n=== Expiring Soon ===");
        manager.getExpiringSoon().forEach(System.out::println);

        System.out.println("\n=== Coverage: Auto ===");
        manager.getByCoverage("Auto").forEach(System.out::println);

        System.out.println("\n=== Duplicate Policy Numbers ===");
        manager.findDuplicatePolicies().forEach(System.out::println);

        System.out.println("\n=== Performance Comparison ===");
        manager.comparePerformance();
    }
}