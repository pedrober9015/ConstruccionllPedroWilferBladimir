package app.infrastructure.Persistence.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.infrastructure.Persistence.entities.PersonEntity;

@Entity
@Table(name = "person_customers")
public class PersonCustomerEntity extends PersonEntity {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "customer_code", nullable = false, unique = true, length = 50)
    private String customerCode;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "national_id", unique = true, length = 20)
    private String nationalId;

    @Column(name = "occupation", length = 100)
    private String occupation;

    @Column(name = "monthly_income")
    private double monthlyIncome;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BankAccountEntity> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanEntity> loans = new ArrayList<>();

    public PersonCustomerEntity() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerCode() { return customerCode; }
    public void setCustomerCode(String customerCode) { this.customerCode = customerCode; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    public List<BankAccountEntity> getAccounts() { return accounts; }
    public void setAccounts(List<BankAccountEntity> accounts) { this.accounts = accounts; }

    public List<LoanEntity> getLoans() { return loans; }
    public void setLoans(List<LoanEntity> loans) { this.loans = loans; }
}
