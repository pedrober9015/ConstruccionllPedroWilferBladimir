package app.domain.ports;

import java.util.List;
import java.util.Optional;

import app.domain.model.BankAccount;
import app.domain.model.Customer;

public interface BankAccountPort {
    //find
    public BankAccount findById(String id);
    public List<BankAccount> findByCustomer(Customer customer);
    //exists
    public boolean existsByNumber(long accountNumber);
    public boolean existsById(String id);
    //operation
    public BankAccount save(BankAccount bankAccount);
    public void update(BankAccount bankAccount);
    public void delete(Long id);
    public Optional<BankAccount> findById(Long id);
    public List<BankAccount> findAll();
}