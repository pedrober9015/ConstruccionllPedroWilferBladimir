package app.domain.ports;

import java.util.List;
import java.util.Optional;
import app.domain.model.BankAccount;
import app.domain.model.Customer;

public interface BankAccountPort {

    // BUSCAR CUENTA POR ID
    public Optional<BankAccount> findById(String id);

    // BUSCAR CUENTAS POR CLIENTE
    public List<BankAccount> findByCustomer(Customer customer);

    // VERIFICAR SI EXISTE NÚMERO DE CUENTA
    public boolean existsByNumber(String accountNumber);

    // VERIFICAR SI EXISTE ID
    public boolean existsById(String id);

    // GUARDAR CUENTA
   public BankAccount save(BankAccount bankAccount);

    // ACTUALIZAR CUENTA
    public void update(BankAccount bankAccount);

    // ELIMINAR CUENTA
    public void delete(String id);

    // OBTENER TODAS LAS CUENTAS
    public List<BankAccount> findAll();
}