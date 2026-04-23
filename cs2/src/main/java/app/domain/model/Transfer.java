package app.domain.model;

import app.domain.model.enums.TransferStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transfer {

    private String transferId;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private double amount;
    private String currency;
    private TransferStatus status;
    private String description;
    private LocalDateTime transferDate;
    private String referenceCode;

    public Transfer() {
        this.transferId = UUID.randomUUID().toString();
        this.transferDate = LocalDateTime.now();
        this.status = TransferStatus.PENDING;
    }

    public Transfer(BankAccount sourceAccount, BankAccount destinationAccount,
                    double amount, String currency, String description) {
        this();
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.referenceCode = "TRF-" + System.currentTimeMillis();
    }

    public void complete() {
        this.status = TransferStatus.COMPLETED;
    }

    public void fail() {
        this.status = TransferStatus.FAILED;
    }

    public void cancel() {
        if (this.status != TransferStatus.PENDING) {
            throw new IllegalStateException("Only pending transfers can be cancelled.");
        }
        this.status = TransferStatus.CANCELLED;
    }

    public String getTransferId() { return transferId; }
    public void setTransferId(String transferId) { this.transferId = transferId; }

    public BankAccount getSourceAccount() { return sourceAccount; }
    public void setSourceAccount(BankAccount sourceAccount) { this.sourceAccount = sourceAccount; }

    public BankAccount getDestinationAccount() { return destinationAccount; }
    public void setDestinationAccount(BankAccount destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public TransferStatus getStatus() { return status; }
    public void setStatus(TransferStatus status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getTransferDate() { return transferDate; }
    public void setTransferDate(LocalDateTime transferDate) { this.transferDate = transferDate; }

    public String getReferenceCode() { return referenceCode; }
    public void setReferenceCode(String referenceCode) { this.referenceCode = referenceCode; }

    @Override
    public String toString() {
        return "Transfer{referenceCode='" + referenceCode + "', amount=" + amount + " " + currency
                + ", status=" + status + ", date=" + transferDate + "}";
    }
}
