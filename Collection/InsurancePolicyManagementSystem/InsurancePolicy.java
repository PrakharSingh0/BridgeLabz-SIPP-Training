package InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.Objects;

public class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String name, LocalDate expiry, String coverage, double premium) {
        this.policyNumber = policyNumber;
        this.policyholderName = name;
        this.expiryDate = expiry;
        this.coverageType = coverage;
        this.premiumAmount = premium;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePolicy)) return false;
        InsurancePolicy p = (InsurancePolicy) o;
        return Objects.equals(policyNumber, p.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | ₹%.2f",
            policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}