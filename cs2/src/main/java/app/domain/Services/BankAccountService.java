package app.domain.services;

import java.util.List;
import java.util.Optional;

import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.model.enums.AccountStatus;
import app.domain.ports.BankAccountPort;

public class BankAccountService {

    private final BankAccountPort bankAccountPort;

    public BankAccountService(BankAccountPort bankAccountPort) {
        this.bankAccountPort = bankAccountPort;
    }

    // CREAR CUENTA
    public BankAccount createAccount(BankAccount account) {

        if (account.getOwner() == null) {
            throw new IllegalArgumentException("La cuenta debe estar asociada a un cliente");
        }

        if (account.getAccountNumber() == null || account.getAccountNumber().isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }

        if (account.getBalance() < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }

        return bankAccountPort.save(account);
    }

    // BUSCAR CUENTA POR ID
    public Optional<BankAccount> findById(String id) {
        return bankAccountPort.findById(id);
    }

    // BUSCAR CUENTAS POR CLIENTE
    public List<BankAccount> findByCustomer(Customer customer) {
        return bankAccountPort.findByCustomer(customer);
    }

    // OBTENER TODAS LAS CUENTAS
    public List<BankAccount> findAll() {
        return bankAccountPort.findAll();
    }

    // REALIZAR DEPÓSITO
    public void depositMoney(String id, double amount) {
        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("No se puede depositar en una cuenta inactiva");
        }

        account.deposit(amount);

        bankAccountPort.update(account);
    }

    // REALIZAR RETIRO
    public void withdrawMoney(String id, double amount) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("No se puede retirar de una cuenta inactiva");
        }

        account.withdraw(amount);

        bankAccountPort.update(account);
    }

    // CONGELAR CUENTA
    public void freezeAccount(String id) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        account.setStatus(AccountStatus.FROZEN);

        bankAccountPort.update(account);
    }

    // DESCONGELAR CUENTA
    public void unfreezeAccount(String id) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        account.setStatus(AccountStatus.ACTIVE);

        bankAccountPort.update(account);
    }

    // CERRAR CUENTA
    public void closeAccount(String id) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (account.getBalance() > 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo");
        }

        account.setStatus(AccountStatus.CLOSED);

        bankAccountPort.update(account);
    }

    // CONSULTAR SALDO
    public double getBalance(String id) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        return account.getBalance();
    }

    // CONSULTAR SALDO DISPONIBLE
    public double getAvailableBalance(String id) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        return account.getAvailableBalance();
    }

    // VALIDAR RETIRO
    public boolean canWithdraw(String id, double amount) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        return account.getStatus() == AccountStatus.ACTIVE
                && amount <= account.getAvailableBalance();
    }

    // OBTENER INFORMACIÓN DE LA CUENTA
    public String getAccountInfo(String id) {

        BankAccount account = bankAccountPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        return "Número de Cuenta: " + account.getAccountNumber() +
               ", Tipo: " + account.getAccountType() +
               ", Saldo: " + account.getBalance() +
               ", Estado: " + account.getStatus();
    }

    // ELIMINAR CUENTA
    public void deleteAccount(String id) {
        bankAccountPort.delete(id);
    }
}