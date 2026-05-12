package app.application.usecases;
import java.time.LocalDate;
import java.util.List;

import app.domain.model.Customer;
import app.domain.model.Loan;
import app.domain.Services.LoanService;

public class LoanUseCases {

    private final LoanService loanService;

    public LoanUseCases(LoanService loanService) {
        this.loanService = loanService;
    }
    // CREAR PRÉSTAMO
    public Loan createLoan(Customer customer,
                           double principal,
                           double interestRate,
                           int termMonths,
                           LocalDate startDate,
                           String purpose) {

        return loanService.createLoan(
                customer,
                principal,
                interestRate,
                termMonths,
                startDate,
                purpose
        );
    }

    // APROBAR PRÉSTAMO
    public void approveLoan(String loanId) {
        loanService.approveLoan(loanId);
    }

    // ACTIVAR PRÉSTAMO
    public void activateLoan(String loanId) {
        loanService.activateLoan(loanId);
    }

    // RECHAZAR PRÉSTAMO
    public void rejectLoan(String loanId) {
        loanService.rejectLoan(loanId);
    }

    // MARCAR COMO MOROSO
    public void markAsDefaulted(String loanId) {
        loanService.markAsDefaulted(loanId);
    }

    // REALIZAR PAGO
    public void makePayment(String loanId, double amount) {
        loanService.makePayment(loanId, amount);
    }

    // OBTENER TODOS LOS PRÉSTAMOS
    public List<Loan> findAllLoans() {
        return loanService.getAllLoans();
    }

    // BUSCAR PRÉSTAMOS POR CLIENTE
    public List<Loan> findLoansByCustomer(Customer customer) {
        return loanService.findByCustomer(customer);
    }
}