package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "corporate_customers")
public class CorporateCustomerEntity extends PersonEntity {

    // ID PRINCIPAL DEL CLIENTE CORPORATIVO
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

    // NIT DE LA EMPRESA
    @Column(name = "tax_id", unique = true, length = 30)
    private String taxId;

    // NOMBRE DE LA EMPRESA
    @Column(name = "company_name", nullable = false, length = 200)
    private String companyName;

    // REPRESENTANTE LEGAL
    @Column(name = "legal_representative", length = 150)
    private String legalRepresentative;


    // SECTOR EMPRESARIAL
    @Column(name = "business_sector", length = 100)
    private String businessSector;

    // INGRESOS ANUALES
    @Column(name = "annual_revenue")
    private double annualRevenue;

    // CONSTRUCTOR VACIO
    public CorporateCustomerEntity() {
    }

    // GETTERS Y SETTERS
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

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}