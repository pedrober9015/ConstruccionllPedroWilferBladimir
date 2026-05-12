package app.domain.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.domain.model.CorporateCustomer;

public class CorporateCustomerService extends CorporateCustomer{

    private final List<CorporateCustomer> corporateCustomers = new ArrayList<>();

    public CorporateCustomer createCorporateCustomer(CorporateCustomer customer) {

        if (customer == null) {
            throw new RuntimeException("Customer cannot be null");
        }

        if (customer.getTaxId() == null || customer.getTaxId().isEmpty()) {
            throw new RuntimeException("TaxId is required");
        }

        if (customer.getCompanyName() == null || customer.getCompanyName().isEmpty()) {
            throw new RuntimeException("Company name is required");
        }

        corporateCustomers.add(customer);
        return customer;
    }

    public Optional<CorporateCustomer> findById(String id) {
        for (CorporateCustomer customer : corporateCustomers) {
            if (customer.getId().equals(id)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public Optional<CorporateCustomer> findByTaxId(String taxId) {
        for (CorporateCustomer customer : corporateCustomers) {
            if (customer.getTaxId().equals(taxId)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public List<CorporateCustomer> findAll() {
        return new ArrayList<>(corporateCustomers);
    }

    public void updateCompanyName(String id, String companyName) {
        CorporateCustomer customer = findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setCompanyName(companyName);
    }

    public void updateAnnualRevenue(String id, double revenue) {
        CorporateCustomer customer = findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (revenue < 0) {
            throw new RuntimeException("Revenue cannot be negative");
        }

        customer.setAnnualRevenue(revenue);
    }
}
    

