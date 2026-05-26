package app.domain.services;

import java.util.List;
import java.util.Optional;

import app.domain.model.CorporateCustomer;
import app.domain.ports.CustomerPort;

public class CorporateCustomerService {

    private final CustomerPort customerPort;

    public CorporateCustomerService(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    // REGISTRAR CLIENTE CORPORATIVO
    public CorporateCustomer createCorporateCustomer(CorporateCustomer customer) {

        if (customer == null) {
            throw new RuntimeException("El cliente no puede ser nulo");
        }

        if (customer.getTaxId() == null || customer.getTaxId().isEmpty()) {
            throw new RuntimeException("El NIT es obligatorio");
        }

        if (customer.getCompanyName() == null || customer.getCompanyName().isEmpty()) {
            throw new RuntimeException("El nombre de la empresa es obligatorio");
        }

        return (CorporateCustomer) customerPort.save(customer);
    }

    // BUSCAR CLIENTE POR ID
    public Optional<CorporateCustomer> findById(String id) {

        Optional<?> customer = customerPort.findById(id);

        if (customer.isPresent() && customer.get() instanceof CorporateCustomer) {
            return Optional.of((CorporateCustomer) customer.get());
        }

        return Optional.empty();
    }

    // OBTENER TODOS LOS CLIENTES CORPORATIVOS
    public List<CorporateCustomer> findAll() {

        return customerPort.findAll()
                .stream()
                .filter(customer -> customer instanceof CorporateCustomer)
                .map(customer -> (CorporateCustomer) customer)
                .toList();
    }

    // ACTUALIZAR NOMBRE DE EMPRESA
    public void updateCompanyName(String id, String companyName) {

        CorporateCustomer customer = findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        customer.setCompanyName(companyName);

        customerPort.update(customer);
    }

    // ACTUALIZAR INGRESOS ANUALES
    public void updateAnnualRevenue(String id, double revenue) {

        if (revenue < 0) {
            throw new RuntimeException("Los ingresos no pueden ser negativos");
        }

        CorporateCustomer customer = findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        customer.setAnnualRevenue(revenue);

        customerPort.update(customer);
    }
}