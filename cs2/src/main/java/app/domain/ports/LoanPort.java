package app.domain.ports;

import java.util.List;
import java.util.Optional;
import app.domain.model.Customer;
import app.domain.model.Loan;

public interface LoanPort {

    // BUSCAR PRÉSTAMO POR ID
    public Optional<Loan> findById(String id);

    // BUSCAR PRÉSTAMOS POR CLIENTE
    public List<Loan> findByCustomer(Customer customer);

    // BUSCAR PRÉSTAMOS POR ESTADO
    public List<Loan> findByStatus(String status);

    // VERIFICAR SI EXISTE
    public boolean existsById(String id);

    // GUARDAR PRÉSTAMO
    public Loan save(Loan loan);

    // ACTUALIZAR PRÉSTAMO
    public void update(Loan loan);

    // ELIMINAR PRÉSTAMO
    public void delete(String id);

    // OBTENER TODOS LOS PRÉSTAMOS
    public List<Loan> findAll();
}