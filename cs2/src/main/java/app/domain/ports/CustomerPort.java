package app.domain.ports;

import java.util.List;
import java.util.Optional;

import app.domain.model.Customer;

public interface CustomerPort {
    //find
    public Customer findByDocument(String identification);
    public List<Customer> findAll();
    //exists
    public boolean existsByDocument(String identification);
    //operation
    public Customer save(Customer customer);
    public void update(Customer customer);
    public void deleteByDocument(String identification);
    public Optional<Customer> findById(Long id);
    public void delete(Long id);
    public Optional<Customer> findById(String type);
}
