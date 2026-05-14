package app.infrastructure.Persistence.entities;

import app.domain.model.enums.ProductType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "product_id", length = 36)
    private String productId;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false, length = 30)
    private ProductType productType;

    @Column(name = "base_interest_rate")
    private double baseInterestRate;

    @Column(name = "minimum_amount")
    private double minimumAmount;

    @Column(name = "maximum_amount")
    private double maximumAmount;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "launch_date")
    private LocalDate launchDate;

    @Column(name = "terms_and_conditions", length = 2000)
    private String termsAndConditions;

    public ProductEntity() {}

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ProductType getProductType() { return productType; }
    public void setProductType(ProductType productType) { this.productType = productType; }

    public double getBaseInterestRate() { return baseInterestRate; }
    public void setBaseInterestRate(double baseInterestRate) { this.baseInterestRate = baseInterestRate; }

    public double getMinimumAmount() { return minimumAmount; }
    public void setMinimumAmount(double minimumAmount) { this.minimumAmount = minimumAmount; }

    public double getMaximumAmount() { return maximumAmount; }
    public void setMaximumAmount(double maximumAmount) { this.maximumAmount = maximumAmount; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public LocalDate getLaunchDate() { return launchDate; }
    public void setLaunchDate(LocalDate launchDate) { this.launchDate = launchDate; }

    public String getTermsAndConditions() { return termsAndConditions; }
    public void setTermsAndConditions(String termsAndConditions) { this.termsAndConditions = termsAndConditions; }
}
