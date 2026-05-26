package app.adapter.in.builders;

import java.time.LocalDate;

import app.domain.model.CorporateCustomer;

public class CorporateCustomerBuilder {

    private final CorporateCustomer customer;

    public CorporateCustomerBuilder() {
        customer = new CorporateCustomer();
    }

    public CorporateCustomerBuilder setId(String id) {
        customer.setId(id);
        return this;
    }

    public CorporateCustomerBuilder setFirstName(String firstName) {
        customer.setFirstName(firstName);
        return this;
    }

    public CorporateCustomerBuilder setLastName(String lastName) {
        customer.setLastName(lastName);
        return this;
    }

    public CorporateCustomerBuilder setEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public CorporateCustomerBuilder setPhoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
        return this;
    }

    public CorporateCustomerBuilder setBirthDate(LocalDate birthDate) {
        customer.setBirthDate(birthDate);
        return this;
    }

    public CorporateCustomerBuilder setAddress(String address) {
        customer.setAddress(address);
        return this;
    }

    public CorporateCustomerBuilder setCustomerCode(String customerCode) {
        customer.setCustomerCode(customerCode);
        return this;
    }

    public CorporateCustomerBuilder setRegistrationDate(LocalDate registrationDate) {
        customer.setRegistrationDate(registrationDate);
        return this;
    }

    public CorporateCustomerBuilder setTaxId(String taxId) {
        customer.setTaxId(taxId);
        return this;
    }

    public CorporateCustomerBuilder setCompanyName(String companyName) {
        customer.setCompanyName(companyName);
        return this;
    }

    public CorporateCustomerBuilder setLegalRepresentative(String legalRepresentative) {
        customer.setLegalRepresentative(legalRepresentative);
        return this;
    }

    public CorporateCustomerBuilder setBusinessSector(String businessSector) {
        customer.setBusinessSector(businessSector);
        return this;
    }

    public CorporateCustomerBuilder setAnnualRevenue(double annualRevenue) {
        customer.setAnnualRevenue(annualRevenue);
        return this;
    }

    public CorporateCustomer build() {
        return customer;
    }
}