package app.adapter.in.builders;

import java.time.LocalDate;

import app.domain.model.Product;
import app.domain.model.enums.ProductType;

public class ProductBuilder {

    private String productId;
    private String name;
    private String description;
    private ProductType productType;
    private double baseInterestRate;
    private double minimumAmount;
    private double maximumAmount;
    private boolean available = true;
    private LocalDate launchDate;
    private String termsAndConditions;

    public ProductBuilder setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public ProductBuilder setBaseInterestRate(double baseInterestRate) {
        this.baseInterestRate = baseInterestRate;
        return this;
    }

    public ProductBuilder setMinimumAmount(double minimumAmount) {
        this.minimumAmount = minimumAmount;
        return this;
    }

    public ProductBuilder setMaximumAmount(double maximumAmount) {
        this.maximumAmount = maximumAmount;
        return this;
    }

    public ProductBuilder setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public ProductBuilder setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
        return this;
    }

    public ProductBuilder setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
        return this;
    }

    public Product build() {
        Product product = new Product();

        product.setProductId(productId);
        product.setName(name);
        product.setDescription(description);
        product.setProductType(productType);
        product.setBaseInterestRate(baseInterestRate);
        product.setMinimumAmount(minimumAmount);
        product.setMaximumAmount(maximumAmount);
        product.setAvailable(available);

        if (launchDate != null) {
            product.setLaunchDate(launchDate);
        }

        product.setTermsAndConditions(termsAndConditions);

        return product;
    }
}
