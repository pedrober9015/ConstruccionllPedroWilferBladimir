package app.domain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import app.domain.model.Customer;
import app.domain.model.Loan;
import app.domain.ports.LoanPort;

public class LoanService {

    private final LoanPort loanPort;

    public LoanService(LoanPort loanPort) {
        this.loanPort = loanPort;
    }

    // CREAR PRÉSTAMO
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

        return loanPort.save(loan);
    }

    // BUSCAR PRÉSTAMO POR ID
    public Optional<Loan> findById(String id) {
        return loanPort.findById(id);
    }

    // BUSCAR PRÉSTAMOS POR CLIENTE
    public List<Loan> findByCustomer(Customer customer) {
        return loanPort.findByCustomer(customer);
    }

    // APROBAR PRÉSTAMO
    public void approveLoan(String id) {

        Loan loan = loanPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.approve();

        loanPort.update(loan);
    }

    // ACTIVAR PRÉSTAMO
    public void activateLoan(String id) {

        Loan loan = loanPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.activate();

        loanPort.update(loan);
    }

    // RECHAZAR PRÉSTAMO
    public void rejectLoan(String id) {

        Loan loan = loanPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.reject();

        loanPort.update(loan);
    }

    // MARCAR PRÉSTAMO COMO MOROSO
    public void markAsDefaulted(String id) {

        Loan loan = loanPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.markAsDefaulted();

        loanPort.update(loan);
    }

    // REALIZAR PAGO
    public void makePayment(String id, double amount) {

        Loan loan = loanPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.makePayment(amount);

        loanPort.update(loan);
    }

    // OBTENER TODOS LOS PRÉSTAMOS
    public List<Loan> getAllLoans() {
        return loanPort.findAll();
    }

    // BUSCAR PRÉSTAMOS POR ESTADO
    public List<Loan> findByStatus(String status) {
        return loanPort.findByStatus(status);
    }

    // ELIMINAR PRÉSTAMO
    public void deleteLoan(String id) {
        loanPort.delete(id);
    }
}