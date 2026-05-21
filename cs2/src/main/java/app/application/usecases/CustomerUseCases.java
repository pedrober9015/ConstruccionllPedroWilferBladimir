package app.application.usecases;
import java.util.List;
import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.model.Loan;
import app.domain.Services.CustomerService;

public class CustomerUseCases {

    private final CustomerService customerService;

    public CustomerUseCases(CustomerService customerService) {
        this.customerService = customerService;
    }

        // REGISTRAR CLIENTE
    public Customer registerCustomer(Customer customer) {
        return customerService.registerCustomer(customer);
    }

    // ACTIVAR CLIENTE
    public void activateCustomer(String customerId) {
        customerService.activateCustomer(customerId);
    }

    // DESACTIVAR CLIENTE
    public void deactivateCustomer(String customerId) {
        customerService.deactivateCustomer(customerId);
    }

    // AGREGAR CUENTA AL CLIENTE
    public void addAccount(String customerId, BankAccount account) {
        customerService.addAccount(customerId, account);
    }

    // AGREGAR PRÉSTAMO AL CLIENTE
    public void addLoan(String customerId, Loan loan) {
        customerService.addLoan(customerId, loan);
    }

    // OBTENER CUENTAS DEL CLIENTE
    public List<BankAccount> getAccounts(String customerId) {
        return customerService.getAccounts(customerId);
    }

    // OBTENER PRESTAMOS DEL CLIENTE
    public List<Loan> getLoans(String customerId) {
        return customerService.getLoans(customerId);
    }

    // OBTENER TODOS LOS CLIENTES
    public List<Customer> findAllCustomers() {
        return customerService.findAll();
    }
}
