package app.domain.model;

import app.domain.model.enums.ProductType;

import java.time.LocalDate;

public class Product {

    private String productId;
    private String name;
    private String description;
    private ProductType productType;
    private double baseInterestRate;
    private double minimumAmount;
    private double maximumAmount;
    private boolean available;
    private LocalDate launchDate;
    private String termsAndConditions;

    public Product() {
        this.available = true;
    }

    public Product(String productId, String name, String description,
                   ProductType productType, double baseInterestRate,
                   double minimumAmount, double maximumAmount) {
        this();
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.baseInterestRate = baseInterestRate;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.launchDate = LocalDate.now();
    }

    public boolean isEligibleAmount(double amount) {
        return amount >= minimumAmount && amount <= maximumAmount;
    }

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
    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    @Override
    public String toString() {
        return "Product{productId='" + productId + "', name='" + name
                + "', type=" + productType + ", interestRate=" + baseInterestRate
                + "%, available=" + available + "}";
    }
}
