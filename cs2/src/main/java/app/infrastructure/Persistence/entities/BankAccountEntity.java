package app.infrastructure.Persistence.entities;

import app.domain.model.Transfer;
import app.domain.model.enums.AccountStatus;
import app.domain.model.enums.AccountType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {

    @Id
    @Column(name = "account_number", length = 20)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false, length = 30)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private AccountStatus status;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "available_balance", nullable = false)
    private double availableBalance;

    @Column(name = "currency", length = 3)
    private String currency;

    @Column(name = "opening_date")
    private LocalDateTime openingDate;

    @Column(name = "last_transaction_date")
    private LocalDateTime lastTransactionDate;

    /**
     * Clave foránea al propietario. Puede ser PersonCustomer o CorporateCustomer;
     * almacenamos el customerCode como discriminador de negocio.
     * La resolución al tipo concreto se hace en el repositorio.
     */
    @Column(name = "owner_customer_code", nullable = false, length = 50)
    private String ownerCustomerCode;

    @OneToMany(mappedBy = "sourceAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransferEntity> transfers = new ArrayList<>();

    public BankAccountEntity() {}

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
    public void setLastTransactionDate(LocalDateTime lastTransactionDate) { this.lastTransactionDate = lastTransactionDate; }

    public String getOwnerCustomerCode() { return ownerCustomerCode; }
    public void setOwnerCustomerCode(String ownerCustomerCode) { this.ownerCustomerCode = ownerCustomerCode; }

    public List<Transfer> getTransfers() { return transfers; }
    public void setTransfers(List<Transfer> transfers) { this.transfers = transfers; }
}
