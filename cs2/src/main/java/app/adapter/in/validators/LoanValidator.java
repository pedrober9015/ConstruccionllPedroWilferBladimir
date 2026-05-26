package app.adapter.in.validators;
import app.domain.model.Loan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanValidator {
    public static List<String> validate(Loan loan) {
        List<String> errors = new ArrayList<>();

        if (loan == null) {
            errors.add("Loan cannot be null");
            return errors;
        }

        validateCustomer(loan.getCustomer(), errors);
        validatePrincipal(loan.getPrincipal(), errors);
        validateInterestRate(loan.getInterestRate(), errors);
        validateTermMonths(loan.getTermMonths(), errors);
        validateStartDate(loan.getStartDate(), errors);

        return errors;
    }

    public static void validateCustomer(Object customer, List<String> errors) {
        if (customer == null) {
            errors.add("Customer cannot be null");
        }
    }

    public static void validatePrincipal(double principal, List<String> errors) {
        if (principal <= 0) {
            errors.add("Principal amount must be greater than zero");
        }
        if (principal < 100) {
            errors.add("Principal amount must be at least 100");
        }
        if (principal > 100000000) {
            errors.add("Principal amount exceeds maximum limit");
        }
    }

    public static void validateInterestRate(double interestRate, List<String> errors) {
        if (interestRate < 0) {
            errors.add("Interest rate cannot be negative");
        }
        if (interestRate > 50) {
            errors.add("Interest rate exceeds maximum limit of 50%");
        }
    }

    public static void validateTermMonths(int termMonths, List<String> errors) {
        if (termMonths <= 0) {
            errors.add("Term in months must be greater than zero");
        }
        if (termMonths < 1) {
            errors.add("Term must be at least 1 month");
        }
        if (termMonths > 360) {
            errors.add("Term must not exceed 360 months (30 years)");
        }
    }

    public static void validateStartDate(LocalDate startDate, List<String> errors) {
        if (startDate == null) {
            errors.add("Start date cannot be null");
        } else if (startDate.isBefore(LocalDate.now())) {
            errors.add("Start date cannot be in the past");
        }
    }

    public static void validateRemainingBalance(double remainingBalance, List<String> errors) {
        if (remainingBalance < 0) {
            errors.add("Remaining balance cannot be negative");
        }
    }

    public static void validatePaymentAmount(double paymentAmount, List<String> errors) {
        if (paymentAmount <= 0) {
            errors.add("Payment amount must be positive");
        }
    }

    public static boolean isValid(Loan loan) {
        return validate(loan).isEmpty();
    }
}
