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

    // VERIFICAR SI EXISTE UNA TRANSFERENCIA
    public boolean existsById(String id) {
        return transferPort.existsById(id);
    }

    // BUSCAR TRANSFERENCIA POR ID
    public Transfer findById(String id) {
        return transferPort.findById(id);
    }

    // BUSCAR TRANSFERENCIAS POR CLIENTE
    public List<Transfer> findByCustomer(Customer customer) {
        return transferPort.findByCustomer(customer);
    }

    // GUARDAR TRANSFERENCIA
    public void save(Transfer transfer) {
        transferPort.save(transfer);
    }

    // ACTUALIZAR TRANSFERENCIA
    public void update(Transfer transfer) {
        transferPort.update(transfer);
    }
}