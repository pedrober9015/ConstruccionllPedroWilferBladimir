package app.application.usecases;
import java.util.List;
import java.util.Optional;

import app.domain.model.BankAccount;
import app.domain.model.Customer;
import app.domain.services.BankAccountService;

public class BankAccountUseCases {

    private final BankAccountService bankAccountService;

    public BankAccountUseCases(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // CREAR CUENTA
    public BankAccount createAccount(BankAccount account) {
        return bankAccountService.createAccount(account);
    }

    // BUSCAR CUENTA POR ID
    public Optional<BankAccount> findById(String id) {
        return bankAccountService.findById(id);
    }

    // BUSCAR CUENTAS POR CLIENTE
    public List<BankAccount> findByCustomer(Customer customer) {
        return bankAccountService.findByCustomer(customer);
    }

    // OBTENER TODAS LAS CUENTAS
    public List<BankAccount> findAllAccounts() {
        return bankAccountService.findAll();
    }

    // DEPOSITAR DINERO
    public void depositMoney(String id, double amount) {
        bankAccountService.depositMoney(id, amount);
    }

    // RETIRAR DINERO
    public void withdrawMoney(String id, double amount) {
        bankAccountService.withdrawMoney(id, amount);
    }

    // CONGELAR CUENTA
    public void freezeAccount(String id) {
        bankAccountService.freezeAccount(id);
    }

    // DESCONGELAR CUENTA
    public void unfreezeAccount(String id) {
        bankAccountService.unfreezeAccount(id);
    }

    // CERRAR CUENTA
    public void closeAccount(String id) {
        bankAccountService.closeAccount(id);
    }

    // OBTENER SALDO
    public double getBalance(String id) {
        return bankAccountService.getBalance(id);
    }

    // OBTENER SALDO DISPONIBLE
    public double getAvailableBalance(String id) {
        return bankAccountService.getAvailableBalance(id);
    }

    // VALIDAR RETIRO
    public boolean canWithdraw(String id, double amount) {
        return bankAccountService.canWithdraw(id, amount);
    }

    // INFORMACIÓN DE LA CUENTA
    public String getAccountInfo(String id) {
        return bankAccountService.getAccountInfo(id);
    }

    // ELIMINAR CUENTA
    public void deleteAccount(String id) {
        bankAccountService.deleteAccount(id);
    }
}