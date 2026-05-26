package app.application.usecases;
import java.util.List;

import app.domain.services.TransferService;
import app.domain.model.Customer;
import app.domain.model.Transfer;

public class TransferUseCases {

    private final TransferService transferService;

    public TransferUseCases(TransferService transferService) {
        this.transferService = transferService;
    }
    // GUARDAR TRANSFERENCIA
    public void saveTransfer(Transfer transfer) {
        transferService.save(transfer);
    }

    // ACTUALIZAR TRANSFERENCIA
    public void updateTransfer(Transfer transfer) {
        transferService.update(transfer);
    }

    // BUSCAR TRANSFERENCIA POR ID
    public Transfer findTransferById(String transferId) {
        return transferService.findById(transferId);
    }

    // VERIFICAR SI EXISTE LA TRANSFERENCIA
    public boolean existsTransfer(String transferId) {
        return transferService.existsById(transferId);
    }

    // BUSCAR TRANSFERENCIAS POR CLIENTE
    public List<Transfer> findTransfersByCustomer(Customer customer) {
        return transferService.findByCustomer(customer);
    }
}