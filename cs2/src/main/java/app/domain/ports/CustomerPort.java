package app.domain.ports;

import java.util.List;
import java.util.Optional;
import app.domain.model.Customer;

public interface CustomerPort {

    // BUSCAR CLIENTE POR DOCUMENTO
    public Customer findByDocument(String identification);

    // BUSCAR CLIENTE POR ID
    public Optional<Customer> findById(String id);

    // OBTENER TODOS LOS CLIENTES
   public List<Customer> findAll();

    // VERIFICAR SI EXISTE DOCUMENTO
    public boolean existsByDocument(String identification);

    // GUARDAR CLIENTE
    public Customer save(Customer customer);

    // ACTUALIZAR CLIENTE
    public void update(Customer customer);

    // ELIMINAR CLIENTE POR DOCUMENTO
    public void deleteByDocument(String identification);

    // ELIMINAR CLIENTE POR ID
    public void delete(String id);

    public Optional<Customer> findById(Long id);

    public void delete(Long id);
}