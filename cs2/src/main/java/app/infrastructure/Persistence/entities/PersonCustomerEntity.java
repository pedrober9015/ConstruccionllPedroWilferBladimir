package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "person_customers")
public class PersonCustomerEntity extends PersonEntity {

    // ID PRINCIPAL DEL CLIENTE
    @Id
    @Column(name = "id", length = 50)
    private String id;

    // CODIGO INTERNO DEL CLIENTE
    @Column(name = "customer_code", nullable = false, unique = true, length = 50)
    private String customerCode;

    // FECHA DE REGISTRO
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // ESTADO DEL CLIENTE
    @Column(name = "active", nullable = false)
    private boolean active;

    // DOCUMENTO NACIONAL
    @Column(name = "national_id", unique = true, length = 20)
    private String nationalId;

    // OCUPACION
    @Column(name = "occupation", length = 100)
    private String occupation;

    // INGRESOS MENSUALES
    @Column(name = "monthly_income")
    private double monthlyIncome;

    public PersonCustomerEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}