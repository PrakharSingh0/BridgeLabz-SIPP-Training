package InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    Set<InsurancePolicy> hashSet = new HashSet<>();
    Set<InsurancePolicy> linkedSet = new LinkedHashSet<>();
    Set<InsurancePolicy> treeSet = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedSet.add(policy);
        treeSet.add(policy);
    }

    public void printAllUnique() {
        System.out.println("HashSet:"); hashSet.forEach(System.out::println);
        System.out.println("\nLinkedHashSet:"); linkedSet.forEach(System.out::println);
        System.out.println("\nTreeSet (Sorted by Expiry):"); treeSet.forEach(System.out::println);
    }

    public List<InsurancePolicy> getExpiringSoon() {
        List<InsurancePolicy> expiring = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (InsurancePolicy p : treeSet) {
            if (!p.getExpiryDate().isAfter(today.plusDays(30))) expiring.add(p);
        }
        return expiring;
    }

    public List<InsurancePolicy> getByCoverage(String type) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) result.add(p);
        }
        return result;
    }

    public Set<String> findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (InsurancePolicy p : linkedSet) {
            if (!seen.add(p.getPolicyNumber())) duplicates.add(p.getPolicyNumber());
        }
        return duplicates;
    }

    public void comparePerformance() {
        int size = 10000;
        List<InsurancePolicy> sample = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            sample.add(new InsurancePolicy("P" + i, "Name" + i, LocalDate.now().plusDays(i % 365),
                i % 2 == 0 ? "Auto" : "Health", 1000 + i));
        }

        measureTime("HashSet", new HashSet<>(), sample);
        measureTime("LinkedHashSet", new LinkedHashSet<>(), sample);
        measureTime("TreeSet", new TreeSet<>(), sample);
    }

    private void measureTime(String type, Set<InsurancePolicy> set, List<InsurancePolicy> sample) {
        long startAdd = System.nanoTime();
        set.addAll(sample);
        long endAdd = System.nanoTime();

        long startSearch = System.nanoTime();
        set.contains(sample.get(sample.size() / 2));
        long endSearch = System.nanoTime();

        long startRemove = System.nanoTime();
        set.remove(sample.get( sample.size() / 2));
        long endRemove = System.nanoTime();

        System.out.printf("\n%s Performance:\nAdd: %.2f ms\nSearch: %.2f µs\nRemove: %.2f µs\n",
            type,
            (endAdd - startAdd) / 1e6,
            (endSearch - startSearch) / 1e3,
            (endRemove - startRemove) / 1e3);
    }
}