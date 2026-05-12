package app.domain.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.model.Loan;
import app.domain.ports.CustomerPort;

public class CustomerService implements CustomerPort {

    private final List<Customer> customers = new ArrayList<>();

    public Customer registerCustomer(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("Customer cannot be null");
        }

        customers.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    public void deactivateCustomer(String id) {
        Customer customer = findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setActive(false);
    }

    public void activateCustomer(String id) {
        Customer customer = findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setActive(true);
    }

    public void addAccount(String customerId, BankAccount account) {
        Customer customer = findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.addAccount(account);
    }

    public void addLoan(String customerId, Loan loan) {
        Customer customer = findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.addLoan(loan);
    }

    public List<BankAccount> getAccounts(String customerId) {
        Customer customer = findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return customer.getAccounts();
    }

    public List<Loan> getLoans(String customerId) {
        Customer customer = findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return customer.getLoans();
    }

    @Override
    public Customer findByDocument(String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDocument'");
    }

    @Override
    public boolean existisByDocument(String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existisByDocument'");
    }

    @Override
    public Customer save(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteByDocument(String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByDocument'");
    }

    @Override
    public Optional<Customer> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
    

