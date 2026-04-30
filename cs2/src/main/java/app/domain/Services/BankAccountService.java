package app.application.services;

import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.model.enums.AccountStatus;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    public void createAccount(BankAccount account) {
        if (account.getOwner() == null) {
            throw new IllegalArgumentException("Bank account must be associated with a customer.");
        }
        if (account.getAccountNumber() == null || account.getAccountNumber().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        if (account.getBalance() < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        account.getOwner().addAccount(account);
    }

    public void depositMoney(BankAccount account, double amount) {
        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot deposit to an inactive account.");
        }
        account.deposit(amount);
    }

    public void withdrawMoney(BankAccount account, double amount) {
        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot withdraw from an inactive account.");
        }
        account.withdraw(amount);
    }

    public double getBalance(BankAccount account) {
        return account.getBalance();
    }

    public double getAvailableBalance(BankAccount account) {
        return account.getAvailableBalance();
    }

    public void freezeAccount(BankAccount account) {
        account.setStatus(AccountStatus.FROZEN);
    }

    public void unfreezeAccount(BankAccount account) {
        account.setStatus(AccountStatus.ACTIVE);
    }

    public void closeAccount(BankAccount account) {
        if (account.getBalance() > 0) {
            throw new IllegalStateException("Cannot close account with remaining balance.");
        }
        account.setStatus(AccountStatus.CLOSED);
    }

    public boolean canWithdraw(BankAccount account, double amount) {
        return account.getStatus() == AccountStatus.ACTIVE && amount <= account.getAvailableBalance();
    }

    public String getAccountInfo(BankAccount account) {
        return "Account Number: " + account.getAccountNumber() +
               ", Type: " + account.getAccountType() +
               ", Balance: " + account.getBalance() +
               ", Status: " + account.getStatus();
    }
}
