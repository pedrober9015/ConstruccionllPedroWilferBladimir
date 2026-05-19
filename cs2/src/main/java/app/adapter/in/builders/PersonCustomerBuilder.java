package app.adapter.in.builders;

import java.time.LocalDate;

import app.domain.model.PersonCustomer;

public class PersonCustomerBuilder {
    private final PersonCustomer customer;

    public PersonCustomerBuilder() {
        customer = new PersonCustomer();
    }

    public PersonCustomerBuilder setId(String id) {
        customer.setId(id);
        return this;
    }

    public PersonCustomerBuilder setFirstName(String firstName) {
        customer.setFirstName(firstName);
        return this;
    }

    public PersonCustomerBuilder setLastName(String lastName) {
        customer.setLastName(lastName);
        return this;
    }

    public PersonCustomerBuilder setEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public PersonCustomerBuilder setPhoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
        return this;
    }

    public PersonCustomerBuilder setBirthDate(LocalDate birthDate) {
        customer.setBirthDate(birthDate);
        return this;
    }

    public PersonCustomerBuilder setAddress(String address) {
        customer.setAddress(address);
        return this;
    }

    public PersonCustomerBuilder setCustomerCode(String customerCode) {
        customer.setCustomerCode(customerCode);
        return this;
    }

    public PersonCustomerBuilder setRegistrationDate(LocalDate registrationDate) {
        customer.setRegistrationDate(registrationDate);
        return this;
    }

    public PersonCustomerBuilder setNationalId(String nationalId) {
        customer.setNationalId(nationalId);
        return this;
    }

    public PersonCustomerBuilder setOccupation(String occupation) {
        customer.setOccupation(occupation);
        return this;
    }

    public PersonCustomerBuilder setMonthlyIncome(double monthlyIncome) {
        customer.setMonthlyIncome(monthlyIncome);
        return this;
    }

    public PersonCustomer build() {
        return customer;
    }
}
