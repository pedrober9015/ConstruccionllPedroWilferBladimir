package app.adapter.in.validators;
import app.domain.model.Product;
import java.util.ArrayList;
import java.util.List;


public class ProductValidator {
    
    public static List<String> validate(Product product) {
        List<String> errors = new ArrayList<>();

        if (product == null) {
            errors.add("Product cannot be null");
            return errors;
        }

        validateProductId(product.getProductId(), errors);
        validateName(product.getName(), errors);
        validateDescription(product.getDescription(), errors);
        validateProductType(product.getProductType(), errors);
        validateBaseInterestRate(product.getBaseInterestRate(), errors);
        validateAmountLimits(product.getMinimumAmount(), product.getMaximumAmount(), errors);

        return errors;
    }

    public static void validateProductId(String productId, List<String> errors) {
        if (productId == null || productId.trim().isEmpty()) {
            errors.add("Product ID cannot be empty");
        } else if (productId.length() < 3) {
            errors.add("Product ID must have at least 3 characters");
        } else if (productId.length() > 20) {
            errors.add("Product ID must have at most 20 characters");
        }
    }

    public static void validateName(String name, List<String> errors) {
        if (name == null || name.trim().isEmpty()) {
            errors.add("Product name cannot be empty");
        } else if (name.length() < 3) {
            errors.add("Product name must have at least 3 characters");
        } else if (name.length() > 100) {
            errors.add("Product name must have at most 100 characters");
        }
    }

    public static void validateDescription(String description, List<String> errors) {
        if (description == null || description.trim().isEmpty()) {
            errors.add("Description cannot be empty");
        } else if (description.length() < 10) {
            errors.add("Description must have at least 10 characters");
        } else if (description.length() > 500) {
            errors.add("Description must have at most 500 characters");
        }
    }

    public static void validateProductType(Object productType, List<String> errors) {
        if (productType == null) {
            errors.add("Product type cannot be null");
        }
    }

    public static void validateBaseInterestRate(double baseInterestRate, List<String> errors) {
        if (baseInterestRate < 0) {
            errors.add("Interest rate cannot be negative");
        }
        if (baseInterestRate > 100) {
            errors.add("Interest rate cannot exceed 100%");
        }
    }

    public static void validateAmountLimits(double minimumAmount, double maximumAmount, List<String> errors) {
        if (minimumAmount < 0) {
            errors.add("Minimum amount cannot be negative");
        }
        if (maximumAmount < 0) {
            errors.add("Maximum amount cannot be negative");
        }
        if (minimumAmount > maximumAmount) {
            errors.add("Minimum amount must be less than or equal to maximum amount");
        }
        if (minimumAmount == 0) {
            errors.add("Minimum amount must be greater than zero");
        }
    }

    public static void validateTermsAndConditions(String termsAndConditions, List<String> errors) {
        if (termsAndConditions != null && termsAndConditions.trim().isEmpty()) {
            errors.add("Terms and conditions cannot be empty if provided");
        } else if (termsAndConditions != null && termsAndConditions.length() > 2000) {
            errors.add("Terms and conditions must have at most 2000 characters");
        }
    }

    public static boolean isValid(Product product) {
        return validate(product).isEmpty();
    }
}
