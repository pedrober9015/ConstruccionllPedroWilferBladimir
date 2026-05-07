package app.adapter.in.controllers;
import app.domain.model.BankAccount;
import app.domain.ports.BankAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bank-accounts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class BankAccountController {
    private final BankAccountPort bankAccountPort;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        try {
            List<BankAccount> accounts = bankAccountPort.findAll();
            return ResponseEntity.ok(accounts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long id) {
        try {
            Optional<BankAccount> account = bankAccountPort.findById(id);
            return account.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        try {
            BankAccount createdAccount = bankAccountPort.save(bankAccount);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<BankAccount> updateBankAccount(@PathVariable Long id, @RequestBody BankAccount bankAccount) {
        try {
            Optional<BankAccount> existingAccount = bankAccountPort.findById(id);
            if (existingAccount.isPresent()) {
                bankAccount.setId(id);
                BankAccount updatedAccount = bankAccountPort.save(bankAccount);
                return ResponseEntity.ok(updatedAccount);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        try {
            Optional<BankAccount> account = bankAccountPort.findById(id);
            if (account.isPresent()) {
                bankAccountPort.delete(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{id}/deposit")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<BankAccount> deposit(@PathVariable Long id, @RequestParam Double amount) {
        try {
            Optional<BankAccount> account = bankAccountPort.findById(id);
            if (account.isPresent()) {
                BankAccount acc = account.get();
                acc.setBalance(acc.getBalance() + amount);
                BankAccount updatedAccount = bankAccountPort.save(acc);
                return ResponseEntity.ok(updatedAccount);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/{id}/withdraw")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<BankAccount> withdraw(@PathVariable Long id, @RequestParam Double amount) {
        try {
            Optional<BankAccount> account = bankAccountPort.findById(id);
            if (account.isPresent()) {
                BankAccount acc = account.get();
                if (acc.getBalance() >= amount) {
                    acc.setBalance(acc.getBalance() - amount);
                    BankAccount updatedAccount = bankAccountPort.save(acc);
                    return ResponseEntity.ok(updatedAccount);
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
