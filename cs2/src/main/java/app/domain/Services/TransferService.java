package app.domain.Services;
import java.util.List;

import app.domain.model.Customer;
import app.domain.model.Transfer;
import app.domain.ports.TransferPort;

public class TransferService {

    private final TransferPort transferPort;


    public TransferService(TransferPort transferPort) {
        this.transferPort = transferPort;
    }

 
    public boolean existsById(String id) {
        return transferPort.existsById(id);
    }


    public Transfer findById(String id) {
        return transferPort.findById(id);
    }


    public List<Transfer> findByCustomer(Customer customer) {
        return transferPort.findByCustomer(customer);
    }


    public void save(Transfer transfer) {
        transferPort.save(transfer);
    }

    public void update(Transfer transfer) {
        transferPort.update(transfer);
    }
}