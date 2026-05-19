package app.domain.services;

import java.util.List;
import java.util.Optional;
import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.model.Loan;
import app.domain.ports.CustomerPort;

public class CustomerService {

    private final CustomerPort customerPort;

    public CustomerService(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    // REGISTRAR CLIENTE
    public Customer registerCustomer(Customer customer) {

        if (customer == null) {
            throw new RuntimeException("El cliente no puede ser nulo");
        }

        return customerPort.save(customer);
    }

    // BUSCAR CLIENTE POR ID
    public Optional<Customer> findById(String id) {
        return customerPort.findById(id);
    }

    // OBTENER TODOS LOS CLIENTES
    public List<Customer> findAll() {
        return customerPort.findAll();
    }

    // ACTIVAR CLIENTE
    public void activateCustomer(String id) {

        Customer customer = customerPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        customer.setActive(true);

        customerPort.update(customer);
    }

    // DESACTIVAR CLIENTE
    public void deactivateCustomer(String id) {

        Customer customer = customerPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        customer.setActive(false);

        customerPort.update(customer);
    }

    // AGREGAR CUENTA AL CLIENTE
    public void addAccount(String customerId, BankAccount account) {

        Customer customer = customerPort.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        customer.addAccount(account);

        customerPort.update(customer);
    }

    // AGREGAR PRÉSTAMO AL CLIENTE
    public void addLoan(String customerId, Loan loan) {

        Customer customer = customerPort.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        customer.addLoan(loan);

        customerPort.update(customer);
    }

    // OBTENER CUENTAS DEL CLIENTE
    public List<BankAccount> getAccounts(String customerId) {

        Customer customer = customerPort.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return customer.getAccounts();
    }

    // OBTENER PRÉSTAMOS DEL CLIENTE
    public List<Loan> getLoans(String customerId) {

        Customer customer = customerPort.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return customer.getLoans();
    }
}
    

