package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer extends Person {

    private String customerCode;
    private LocalDate registrationDate;
    private boolean active;
    private List<BankAccount> accounts;
    private List<Loan> loans;

    public Customer() {
        this.accounts = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.active = true;
    }

    public Customer(String id, String firstName, String lastName, String email,
                    String phoneNumber, LocalDate birthDate, String address,
                    String customerCode, LocalDate registrationDate) {
        super(id, firstName, lastName, email, phoneNumber, birthDate, address);
        this.customerCode = customerCode;
        this.registrationDate = registrationDate;
        this.active = true;
        this.accounts = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public String getCustomerCode() { return customerCode; }
    public void setCustomerCode(String customerCode) { this.customerCode = customerCode; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public List<BankAccount> getAccounts() { return accounts; }
    public void setAccounts(List<BankAccount> accounts) { this.accounts = accounts; }

    public List<Loan> getLoans() { return loans; }
    public void setLoans(List<Loan> loans) { this.loans = loans; }

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public abstract String getCustomerType();

    @Override
    public String toString() {
        return "Customer{customerCode='" + customerCode + "', type='" + getCustomerType()
                + "', active=" + active + "}";
    }
}
