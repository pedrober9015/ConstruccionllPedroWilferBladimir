package app.domain.Services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.domain.model.Customer;
import app.domain.model.Loan;
import app.domain.ports.LoanPort;

public class LoanService implements LoanPort {

    private final List<Loan> loans = new ArrayList<>();

    public Loan createLoan(Customer customer,
                           double principal,
                           double interestRate,
                           int termMonths,
                           LocalDate startDate,
                           String purpose) {

        Loan loan = new Loan(
                customer,
                principal,
                interestRate,
                termMonths,
                startDate,
                purpose
        );

        loans.add(loan);
        return loan;
    }

    public Optional<Loan> findById(String loanId) {
        for (Loan loan : loans) {
            if (loan.getLoanId().equals(loanId)) {
                return Optional.of(loan);
            }
        }
        return Optional.empty();
    }

    public List<Loan> findByCustomer(Customer customer) {
        List<Loan> result = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getCustomer() != null &&
                loan.getCustomer().equals(customer)) {
                result.add(loan);
            }
        }

        return result;
    }

    public void approveLoan(String loanId) {
        Loan loan = getLoanOrThrow(loanId);
        loan.approve();
    }

    public void activateLoan(String loanId) {
        Loan loan = getLoanOrThrow(loanId);
        loan.activate();
    }

    public void rejectLoan(String loanId) {
        Loan loan = getLoanOrThrow(loanId);
        loan.reject();
    }

    public void markAsDefaulted(String loanId) {
        Loan loan = getLoanOrThrow(loanId);
        loan.markAsDefaulted();
    }

    public void makePayment(String loanId, double amount) {
        Loan loan = getLoanOrThrow(loanId);
        loan.makePayment(amount);
    }

    public List<Loan> getAllLoans() {
        return new ArrayList<>(loans);
    }

    private Loan getLoanOrThrow(String loanId) {
        return findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    @Override
    public Optional<Loan> findById1(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById1'");
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Loan save(Loan loan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Loan loan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Loan> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Loan> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Loan> findByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
