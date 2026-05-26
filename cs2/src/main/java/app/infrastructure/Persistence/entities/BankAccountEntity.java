package app.infrastructure.persistence.entities;

import app.domain.model.enums.AccountStatus;
import app.domain.model.enums.AccountType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {

    // NUMERO DE CUENTA
    // Clave primaria de la tabla bank_accounts
    @Id
    @Column(name = "account_number", length = 20)
    private String accountNumber;


    // TIPO DE CUENTA
    // Se guarda como texto en la base de datos
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false, length = 30)
    private AccountType accountType;

    // ESTADO DE LA CUENTA
    // ACTIVE, BLOCKED, CLOSED, etc.
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private AccountStatus status;

    // SALDO TOTAL DE LA CUENTA
    @Column(name = "balance", nullable = false)
    private double balance;

    // SALDO DISPONIBLE PARA RETIROS
    @Column(name = "available_balance", nullable = false)
    private double availableBalance;

    // MONEDA DE LA CUENTA
    // Ejemplo: COP, USD, EUR
    @Column(name = "currency", length = 3)
    private String currency;

    // FECHA DE APERTURA
    @Column(name = "opening_date")
    private LocalDateTime openingDate;

    // FECHA DE LA ULTIMA TRANSACCION
    @Column(name = "last_transaction_date")
    private LocalDateTime lastTransactionDate;

    // CODIGO DEL CLIENTE PROPIETARIO
    // Relacion manejada manualmente
    @Column(name = "owner_customer_code", nullable = false, length = 50)
    private String ownerCustomerCode;

    // LISTA DE TRANSFERENCIAS REALIZADAS
    // Relacion uno a muchos con TransferEntity
    @OneToMany(mappedBy = "sourceAccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TransferEntity> transfers = new ArrayList<>();


    // CONSTRUCTOR VACIO NECESARIO PARA JPA
    public BankAccountEntity() {
    }

    // GETTERS Y SETTERS

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDateTime getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public String getOwnerCustomerCode() {
        return ownerCustomerCode;
    }

    public void setOwnerCustomerCode(String ownerCustomerCode) {
        this.ownerCustomerCode = ownerCustomerCode;
    }

    public List<TransferEntity> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferEntity> transfers) {
        this.transfers = transfers;
    }
}