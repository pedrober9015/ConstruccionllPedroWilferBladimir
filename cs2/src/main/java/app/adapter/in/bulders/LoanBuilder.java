package app.adapter.in.bulders;
import java.time.LocalDate;

import app.domain.model.Customer;
import app.domain.model.Loan;

public class LoanBuilder {

    private final Loan loan;

    public LoanBuilder() {
        loan = new Loan();
    }

    public LoanBuilder setCustomer(Customer customer) {
        loan.setCustomer(customer);
        return this;
    }

    public LoanBuilder setPrincipal(double principal) {
        loan.setPrincipal(principal);
        return this;
    }

    public LoanBuilder setInterestRate(double interestRate) {
        loan.setInterestRate(interestRate);
        return this;
    }

    public LoanBuilder setTermMonths(int termMonths) {
        loan.setTermMonths(termMonths);
        return this;
    }

    public LoanBuilder setStartDate(LocalDate startDate) {
        loan.setStartDate(startDate);
        return this;
    }

    public LoanBuilder setPurpose(String purpose) {
        loan.setPurpose(purpose);
        return this;
    }

    public Loan build() {
        return loan;
    }
}    