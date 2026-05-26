package app.adapter.in.validators;
import app.domain.model.BankAccount;
import java.util.ArrayList;
import java.util.List;

public class BankAccountValidator {
public static List<String> validate(BankAccount bankAccount) {
        List<String> errors = new ArrayList<>();

        if (bankAccount == null) {
            errors.add("Bank account cannot be null");
            return errors;
        }

        validateAccountNumber(bankAccount.getAccountNumber(), errors);
        validateAccountType(bankAccount.getAccountType(), errors);
        validateBalance(bankAccount.getBalance(), errors);
        validateAvailableBalance(bankAccount.getAvailableBalance(), errors);
        validateCurrency(bankAccount.getCurrency(), errors);

        return errors;
    }

    public static void validateAccountNumber(String accountNumber, List<String> errors) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            errors.add("Account number cannot be empty");
        } else if (accountNumber.length() < 10) {
            errors.add("Account number must have at least 10 digits");
        } else if (accountNumber.length() > 20) {
            errors.add("Account number must have at most 20 characters");
        } else if (!accountNumber.matches("^[0-9]+$")) {
            errors.add("Account number must contain only digits");
        }
    }

    public static void validateAccountType(Object accountType, List<String> errors) {
        if (accountType == null) {
            errors.add("Account type cannot be null");
        }
    }

    public static void validateBalance(double balance, List<String> errors) {
        if (balance < 0) {
            errors.add("Balance cannot be negative");
        }
        if (balance > 999999999.99) {
            errors.add("Balance exceeds maximum limit");
        }
    }

    public static void validateAvailableBalance(double availableBalance, List<String> errors) {
        if (availableBalance < 0) {
            errors.add("Available balance cannot be negative");
        }
        if (availableBalance > 999999999.99) {
            errors.add("Available balance exceeds maximum limit");
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

    public static void validateDeposit(double amount, List<String> errors) {
        if (amount <= 0) {
            errors.add("Deposit amount must be positive");
        }
        if (amount > 999999999.99) {
            errors.add("Deposit amount exceeds maximum limit");
        }
    }

    public static void validateWithdraw(double amount, double availableBalance, List<String> errors) {
        if (amount <= 0) {
            errors.add("Withdrawal amount must be positive");
        }
        if (amount > availableBalance) {
            errors.add("Insufficient funds for this withdrawal");
        }
    }

    public static boolean isValid(BankAccount bankAccount) {
        return validate(bankAccount).isEmpty();
    }
    
}