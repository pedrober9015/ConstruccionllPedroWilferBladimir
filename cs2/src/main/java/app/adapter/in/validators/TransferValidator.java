package app.adapter.in.validators;
import app.domain.model.Transfer;
import java.util.ArrayList;
import java.util.List;

public class TransferValidator {
    public static List<String> validate(Transfer transfer) {
        List<String> errors = new ArrayList<>();

        if (transfer == null) {
            errors.add("Transfer cannot be null");
            return errors;
        }

        validateSourceAccount(transfer.getSourceAccount(), errors);
        validateDestinationAccount(transfer.getDestinationAccount(), errors);
        validateAmount(transfer.getAmount(), errors);
        validateCurrency(transfer.getCurrency(), errors);
        validateDescription(transfer.getDescription(), errors);

        return errors;
    }

    public static void validateSourceAccount(Object sourceAccount, List<String> errors) {
        if (sourceAccount == null) {
            errors.add("Source account cannot be null");
        }
    }

    public static void validateDestinationAccount(Object destinationAccount, List<String> errors) {
        if (destinationAccount == null) {
            errors.add("Destination account cannot be null");
        }
    }

    public static void validateAmount(double amount, List<String> errors) {
        if (amount <= 0) {
            errors.add("Transfer amount must be positive");
        }
        if (amount < 0.01) {
            errors.add("Transfer amount must be at least 0.01");
        }
        if (amount > 999999999.99) {
            errors.add("Transfer amount exceeds maximum limit");
        }
    }

    public static void validateCurrency(String currency, List<String> errors) {
        if (currency == null || currency.trim().isEmpty()) {
            errors.add("Currency cannot be empty");
        } else if (currency.length() != 3) {
            errors.add("Currency code must be 3 characters (ISO 4217)");
        } else if (!currency.matches("^[A-Z]{3}$")) {
            errors.add("Currency code must contain only uppercase letters");
        }
    }

    public static void validateDescription(String description, List<String> errors) {
        if (description == null || description.trim().isEmpty()) {
            errors.add("Description cannot be empty");
        } else if (description.length() < 3) {
            errors.add("Description must have at least 3 characters");
        } else if (description.length() > 500) {
            errors.add("Description must have at most 500 characters");
        }
    }

    public static void validateCancel(Object transferStatus, List<String> errors) {
        if (transferStatus == null) {
            errors.add("Transfer status is null");
        }
    }

    public static boolean isValid(Transfer transfer) {
        return validate(transfer).isEmpty();
    }
}
