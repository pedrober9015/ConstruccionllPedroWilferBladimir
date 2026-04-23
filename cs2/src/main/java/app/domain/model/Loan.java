package app.domain.model;

import app.domain.model.enums.LoanStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {

    private String loanId;
    private Customer customer;
    private double principal;
    private double interestRate;
    private int termMonths;
    private double monthlyPayment;
    private double remainingBalance;
    private LoanStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate nextPaymentDate;
    private String purpose;

    public Loan() {
        this.loanId = UUID.randomUUID().toString();
        this.status = LoanStatus.PENDING;
    }

    public Loan(Customer customer, double principal, double interestRate,
                int termMonths, LocalDate startDate, String purpose) {
        this();
        this.customer = customer;
        this.principal = principal;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.remainingBalance = principal;
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(termMonths);
        this.nextPaymentDate = startDate.plusMonths(1);
        this.purpose = purpose;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    private double calculateMonthlyPayment() {
        if (interestRate == 0) return principal / termMonths;
        double monthlyRate = interestRate / 12 / 100;
        return principal * (monthlyRate * Math.pow(1 + monthlyRate, termMonths))
                / (Math.pow(1 + monthlyRate, termMonths) - 1);
    }

    public void makePayment(double paymentAmount) {
        if (status != LoanStatus.ACTIVE) {
            throw new IllegalStateException("Loan is not active.");
        }
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
        this.remainingBalance -= paymentAmount;
        this.nextPaymentDate = this.nextPaymentDate.plusMonths(1);
        if (this.remainingBalance <= 0) {
            this.remainingBalance = 0;
            this.status = LoanStatus.PAID;
        }
    }

    public void approve() { this.status = LoanStatus.APPROVED; }
    public void activate() { this.status = LoanStatus.ACTIVE; }
    public void reject() { this.status = LoanStatus.REJECTED; }
    public void markAsDefaulted() { this.status = LoanStatus.DEFAULTED; }

    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public double getPrincipal() { return principal; }
    public void setPrincipal(double principal) { this.principal = principal; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public int getTermMonths() { return termMonths; }
    public void setTermMonths(int termMonths) { this.termMonths = termMonths; }

    public double getMonthlyPayment() { return monthlyPayment; }
    public void setMonthlyPayment(double monthlyPayment) { this.monthlyPayment = monthlyPayment; }

    public double getRemainingBalance() { return remainingBalance; }
    public void setRemainingBalance(double remainingBalance) { this.remainingBalance = remainingBalance; }

    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalDate getNextPaymentDate() { return nextPaymentDate; }
    public void setNextPaymentDate(LocalDate nextPaymentDate) { this.nextPaymentDate = nextPaymentDate; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    @Override
    public String toString() {
        return "Loan{loanId='" + loanId + "', principal=" + principal
                + ", interestRate=" + interestRate + "%, termMonths=" + termMonths
                + ", monthlyPayment=" + String.format("%.2f", monthlyPayment)
                + ", remainingBalance=" + remainingBalance + ", status=" + status + "}";
    }
}
