package app.adapter.in.builders;

import app.domain.model.BankAccount;
import app.domain.model.Transfer;

public class TransferBuilder {

    private final Transfer transfer;

    public TransferBuilder() {
        transfer = new Transfer();
    }

    public TransferBuilder setSourceAccount(BankAccount source) {
        transfer.setSourceAccount(source);
        return this;
    }

    public TransferBuilder setDestinationAccount(BankAccount destination) {
        transfer.setDestinationAccount(destination);
        return this;
    }

    public TransferBuilder setAmount(double amount) {
        transfer.setAmount(amount);
        return this;
    }

    public TransferBuilder setCurrency(String currency) {
        transfer.setCurrency(currency);
        return this;
    }

    public TransferBuilder setDescription(String description) {
        transfer.setDescription(description);
        return this;
    }

    public Transfer build() {
        return transfer;
    }
}