package app.domain.model;

import  app.domain.model.enums.AccountStatus;
import app.domain.model.enums.AccountType;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;
    private AccountType accountType;
    private AccountStatus status;
    private double balance;
    private double availableBalance;
    private String currency;
    private LocalDateTime openingDate;
    private LocalDateTime lastTransactionDate;
    private Customer owner;
    private List<Transfer> transfers;

    public BankAccount() {
        this.transfers = new ArrayList<>();
        this.currency = "COP";
        this.status = AccountStatus.ACTIVE;
        this.openingDate = LocalDateTime.now();
    }

    public BankAccount(String accountNumber, AccountType accountType, double initialBalance,
                       String currency, Customer owner) {
        this();
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
        this.availableBalance = initialBalance;
        this.currency = currency;
        this.owner = owner;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        this.balance += amount;
        this.availableBalance += amount;
        this.lastTransactionDate = LocalDateTime.now();
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > this.availableBalance) throw new IllegalStateException("Insufficient funds.");
        this.balance -= amount;
        this.availableBalance -= amount;
        this.lastTransactionDate = LocalDateTime.now();
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    public AccountStatus getStatus() { return status; }
    public void setStatus(AccountStatus status) { this.status = status; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public double getAvailableBalance() { return availableBalance; }
    public void setAvailableBalance(double availableBalance) { this.availableBalance = availableBalance; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public LocalDateTime getOpeningDate() { return openingDate; }
    public void setOpeningDate(LocalDateTime openingDate) { this.openingDate = openingDate; }

    public LocalDateTime getLastTransactionDate() { return lastTransactionDate; }
    public void setLastTransactionDate(LocalDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public Customer getOwner() { return owner; }
    public void setOwner(Customer owner) { this.owner = owner; }

    public List<Transfer> getTransfers() { return transfers; }
    public void setTransfers(List<Transfer> transfers) { this.transfers = transfers; }

    public void addTransfer(Transfer transfer) { this.transfers.add(transfer); }

    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', type=" + accountType
                + ", balance=" + balance + " " + currency + ", status=" + status + "}";
    }
}
