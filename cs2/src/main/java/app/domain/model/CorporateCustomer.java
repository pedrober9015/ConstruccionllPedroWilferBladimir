package app.domain.model;

import java.time.LocalDate;

public class CorporateCustomer extends Customer {

    private String taxId;
    private String companyName;
    private String legalRepresentative;
    private String businessSector;
    private double annualRevenue;

    public CorporateCustomer() {}

    public CorporateCustomer(String id, String firstName, String lastName, String email,
                             String phoneNumber, LocalDate birthDate, String address,
                             String customerCode, LocalDate registrationDate,
                             String taxId, String companyName, String legalRepresentative,
                             String businessSector, double annualRevenue) {
        super(id, firstName, lastName, email, phoneNumber, birthDate, address,
              customerCode, registrationDate);
        this.taxId = taxId;
        this.companyName = companyName;
        this.legalRepresentative = legalRepresentative;
        this.businessSector = businessSector;
        this.annualRevenue = annualRevenue;
    }

    public String getTaxId() { return taxId; }
    public void setTaxId(String taxId) { this.taxId = taxId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getLegalRepresentative() { return legalRepresentative; }
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getBusinessSector() { return businessSector; }
    public void setBusinessSector(String businessSector) { this.businessSector = businessSector; }

    public double getAnnualRevenue() { return annualRevenue; }
    public void setAnnualRevenue(double annualRevenue) { this.annualRevenue = annualRevenue; }

    @Override
    public String getCustomerType() {
        return "CORPORATE";
    }

    @Override
    public String toString() {
        return "CorporateCustomer{taxId='" + taxId + "', companyName='" + companyName
                + "', businessSector='" + businessSector + "', " + super.toString() + "}";
    }
}
