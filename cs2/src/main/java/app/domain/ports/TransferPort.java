package app.domain.ports;

import java.util.List;
import app.domain.model.Customer;
import app.domain.model.Transfer;

public interface TransferPort {

    // VERIFICAR SI EXISTE
    public boolean existsById(String id);

    // BUSCAR TRANSFERENCIA POR ID
    public Transfer findById(String id);

    // BUSCAR TRANSFERENCIAS POR CLIENTE
    public List<Transfer> findByCustomer(Customer customer);

    // GUARDAR TRANSFERENCIA
    public Transfer save(Transfer transfer);

    // ACTUALIZAR TRANSFERENCIA
    public void update(Transfer transfer);

    // ELIMINAR TRANSFERENCIA
    public void delete(String id);

    // OBTENER TODAS LAS TRANSFERENCIAS
    public List<Transfer> findAll();
}