package app.infrastructure.Persistence.entities;

import app.domain.model.enums.TransferStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class TransferEntity {

    @Id
    @Column(name = "transfer_id", length = 36)
    private String transferId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_account_number", nullable = false)
    private BankAccountEntity sourceAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_account_number", nullable = false)
    private BankAccountEntity destinationAccount;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "currency", length = 3)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private TransferStatus status;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

    @Column(name = "reference_code", unique = true, length = 50)
    private String referenceCode;

    public TransferEntity() {}

    public String getTransferId() { return transferId; }
    public void setTransferId(String transferId) { this.transferId = transferId; }

    public BankAccountEntity getSourceAccount() { return sourceAccount; }
    public void setSourceAccount(BankAccountEntity sourceAccount) { this.sourceAccount = sourceAccount; }

    public BankAccountEntity getDestinationAccount() { return destinationAccount; }
    public void setDestinationAccount(BankAccountEntity destinationAccount) { this.destinationAccount = destinationAccount; }

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
}
