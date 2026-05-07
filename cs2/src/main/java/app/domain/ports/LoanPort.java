package app.domain.ports;

import java.util.List;
import java.util.Optional;

import app.domain.model.Customer;
import app.domain.model.Loan;

public interface LoanPort {
    //find
    public Optional<Loan> findById1(Long id);
    public List<Loan> findByCustomer(Customer customer);
    //exists
    public boolean existsById(String id);
    //operation
    public Loan save(Loan loan);
    public void update(Loan loan);
    public List<Loan> findAll();
    public Optional<Loan> findById(Long id);
    public List<Loan> findByStatus(String status);
    public void delete(Long id);
}