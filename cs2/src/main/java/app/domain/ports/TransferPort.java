package app.domain.ports;

import java.util.List;

import app.domain.model.Customer;
import app.domain.model.Transfer;

public interface  TransferPort {
    public boolean existisById(String id);
    public Transfer findById(String Id);
    public List<Transfer> findByCustomer(Customer customer);
    public void save(Transfer transfere);
    public void update(Transfer transfer);
}