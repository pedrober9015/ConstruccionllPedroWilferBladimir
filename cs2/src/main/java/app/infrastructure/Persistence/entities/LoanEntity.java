package app.infrastructure.Persistence.entities;

import app.domain.model.enums.LoanStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class LoanEntity {

    @Id
    @Column(name = "loan_id", length = 36)
    private String loanId;

    /**
     * Relación polimórfica hacia el cliente: puede ser PersonCustomer o CorporateCustomer.
     * Se almacena como customerCode + discriminador de tipo para resolver en el repositorio.
     */
    @Column(name = "customer_code", nullable = false, length = 50)
    private String customerCode;

    @Column(name = "customer_type", nullable = false, length = 20)
    private String customerType;           // "NATURAL_PERSON" | "CORPORATE"

    @Column(name = "principal", nullable = false)
    private double principal;

    @Column(name = "interest_rate", nullable = false)
    private double interestRate;

    @Column(name = "term_months", nullable = false)
    private int termMonths;

    @Column(name = "monthly_payment")
    private double monthlyPayment;

    @Column(name = "remaining_balance")
    private double remainingBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private LoanStatus status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "next_payment_date")
    private LocalDate nextPaymentDate;

    @Column(name = "purpose", length = 255)
    private String purpose;

    // Relación JPA inversa (usada desde PersonCustomerEntity / CorporateCustomerEntity)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_customer_id", insertable = false, updatable = false)
    private PersonCustomerEntity personCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporate_customer_id", insertable = false, updatable = false)
    private CorporateCustomerEntity corporateCustomer;

    public LoanEntity() {}

    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }

    public String getCustomerCode() { return customerCode; }
    public void setCustomerCode(String customerCode) { this.customerCode = customerCode; }

    public String getCustomerType() { return customerType; }
    public void setCustomerType(String customerType) { this.customerType = customerType; }

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

    public PersonCustomerEntity getPersonCustomer() { return personCustomer; }
    public void setPersonCustomer(PersonCustomerEntity personCustomer) { this.personCustomer = personCustomer; }

    public CorporateCustomerEntity getCorporateCustomer() { return corporateCustomer; }
    public void setCorporateCustomer(CorporateCustomerEntity corporateCustomer) { this.corporateCustomer = corporateCustomer; }
}
