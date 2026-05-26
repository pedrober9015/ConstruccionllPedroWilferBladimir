package app.infrastructure.persistence.entities;

import app.domain.model.enums.TransferStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class TransferEntity {

    // ID DE LA TRANSFERENCIA
    @Id
    @Column(name = "transfer_id", length = 36)
    private String transferId;

    // CUENTA ORIGEN
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_account_number", nullable = false)
    private BankAccountEntity sourceAccount;

    // CUENTA DESTINO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_account_number", nullable = false)
    private BankAccountEntity destinationAccount;

    // MONTO DE LA TRANSFERENCIA
    @Column(name = "amount", nullable = false)
    private double amount;

    // MONEDA
    @Column(name = "currency", length = 3)
    private String currency;

    // ESTADO DE LA TRANSFERENCIA
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private TransferStatus status;

    // DESCRIPCION DE LA TRANSFERENCIA
    @Column(name = "description", length = 255)
    private String description;

    // FECHA DE LA TRANSFERENCIA
    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

    // CODIGO DE REFERENCIA
    @Column(name = "reference_code", unique = true, length = 50)
    private String referenceCode;

    public TransferEntity() {
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public BankAccountEntity getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(BankAccountEntity sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public BankAccountEntity getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(BankAccountEntity destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }
}