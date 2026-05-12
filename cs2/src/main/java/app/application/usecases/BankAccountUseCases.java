package app.application.usecases;
import app.domain.model.BankAccount;
import app.domain.Services.BankAccountService;

public class BankAccountUseCases {

    private final BankAccountService bankAccountService;

    public BankAccountUseCases(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    // CREAR CUENTA
    public void createAccount(BankAccount account) {
        bankAccountService.createAccount(account);
    }

    // DEPOSITAR DINERO
    public void depositMoney(BankAccount account, double amount) {
        bankAccountService.depositMoney(account, amount);
    }

    // RETIRAR DINERO
    public void withdrawMoney(BankAccount account, double amount) {
        bankAccountService.withdrawMoney(account, amount);
    }

    // CONGELAR CUENTA
    public void freezeAccount(BankAccount account) {
        bankAccountService.freezeAccount(account);
    }

    // DESCONGELAR CUENTA
    public void unfreezeAccount(BankAccount account) {
        bankAccountService.unfreezeAccount(account);
    }

    // CERRAR CUENTA
    public void closeAccount(BankAccount account) {
        bankAccountService.closeAccount(account);
    }

    // OBTENER SALDO
    public double getBalance(BankAccount account) {
        return bankAccountService.getBalance(account);
    }

    // OBTENER SALDO DISPONIBLE
    public double getAvailableBalance(BankAccount account) {
        return bankAccountService.getAvailableBalance(account);
    }

    // VALIDAR RETIRO
    public boolean canWithdraw(BankAccount account, double amount) {
        return bankAccountService.canWithdraw(account, amount);
    }

    // INFORMACION DE LA CUENTA
    public String getAccountInfo(BankAccount account) {
        return bankAccountService.getAccountInfo(account);
    }
}