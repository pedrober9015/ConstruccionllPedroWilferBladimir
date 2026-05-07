package app.adapter.in.validators;
import app.domain.model.Customer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {
     public static List<String> validate(Customer customer) {
        List<String> errors = new ArrayList<>();

        if (customer == null) {
            errors.add("Customer cannot be null");
            return errors;
        }

        // Validate inherited Person fields
        validatePersonFields(customer, errors);

        // Validate Customer-specific fields
        validateCustomerCode(customer.getCustomerCode(), errors);
        validateRegistrationDate(customer.getRegistrationDate(), errors);

        return errors;
    }

    private static void validatePersonFields(Customer customer, List<String> errors) {
        PersonValidator.validateId(customer.getId(), errors);
        PersonValidator.validateFirstName(customer.getFirstName(), errors);
        PersonValidator.validateFirstName(customer.getLastName(), errors);
        PersonValidator.validateId(customer.getEmail(), errors);
        PersonValidator.validatePhoneNumber(customer.getPhoneNumber(), errors);
        PersonValidator.validateBirthDate(customer.getBirthDate(), errors);
        PersonValidator.validateId(customer.getAddress(), errors);
    }

    public static void validateCustomerCode(String customerCode, List<String> errors) {
        if (customerCode == null || customerCode.trim().isEmpty()) {
            errors.add("Customer code cannot be empty");
        } else if (customerCode.length() < 5) {
            errors.add("Customer code must have at least 5 characters");
        } else if (customerCode.length() > 20) {
            errors.add("Customer code must have at most 20 characters");
        } else if (!customerCode.matches("^[A-Z0-9]+$")) {
            errors.add("Customer code must contain only uppercase letters and numbers");
        }
    }

    public static void validateRegistrationDate(LocalDate registrationDate, List<String> errors) {
        if (registrationDate == null) {
            errors.add("Registration date cannot be null");
        } else if (registrationDate.isAfter(LocalDate.now())) {
            errors.add("Registration date cannot be in the future");
        }
    }

    public static void validateAccountsLimit(Customer customer, int maxAccounts, List<String> errors) {
        if (customer != null && customer.getAccounts() != null && customer.getAccounts().size() > maxAccounts) {
            errors.add("Customer has exceeded maximum number of accounts (" + maxAccounts + ")");
        }
    }

    public static void validateLoansLimit(Customer customer, int maxLoans, List<String> errors) {
        if (customer != null && customer.getLoans() != null && customer.getLoans().size() > maxLoans) {
            errors.add("Customer has exceeded maximum number of loans (" + maxLoans + ")");
        }
    }

    public static boolean isValid(Customer customer) {
        return validate(customer).isEmpty();
    }
}
