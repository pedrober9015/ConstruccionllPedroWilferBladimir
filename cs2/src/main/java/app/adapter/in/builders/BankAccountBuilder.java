package app.adapter.in.builders;

import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.model.enums.AccountType;

public class BankAccountBuilder {

    private final BankAccount account;

    public BankAccountBuilder() {
        account = new BankAccount();
    }

    public BankAccountBuilder setAccountNumber(String accountNumber) {
        account.setAccountNumber(accountNumber);
        return this;
    }

    public BankAccountBuilder setAccountType(AccountType accountType) {
        account.setAccountType(accountType);
        return this;
    }

    public BankAccountBuilder setBalance(double balance) {
        account.setBalance(balance);
        account.setAvailableBalance(balance);
        return this;
    }

    public BankAccountBuilder setCurrency(String currency) {
        account.setCurrency(currency);
        return this;
    }

    public BankAccountBuilder setOwner(Customer owner) {
        account.setOwner(owner);
        return this;
    }

    public BankAccount build() {
        return account;
    }

}
