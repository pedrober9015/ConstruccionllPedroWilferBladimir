package app.domain.model;

import java.time.LocalDate;

public class PersonCustomer extends Customer {

    private String nationalId;
    private String occupation;
    private double monthlyIncome;

    public PersonCustomer() {}

    public PersonCustomer(String id, String firstName, String lastName, String email,
                          String phoneNumber, LocalDate birthDate, String address,
                          String customerCode, LocalDate registrationDate,
                          String nationalId, String occupation, double monthlyIncome) {
        super(id, firstName, lastName, email, phoneNumber, birthDate, address,
              customerCode, registrationDate);
        this.nationalId = nationalId;
        this.occupation = occupation;
        this.monthlyIncome = monthlyIncome;
    }

    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    @Override
    public String getCustomerType() {
        return "NATURAL_PERSON";
    }

    @Override
    public String toString() {
        return "PersonCustomer{nationalId='" + nationalId + "', occupation='" + occupation
                + "', monthlyIncome=" + monthlyIncome + ", " + super.toString() + "}";
    }
}
