package adapter.in.controllers;
import app.domain.model.Loan;
import app.domain.ports.LoanPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class LoanController {
      private final LoanPort loanPort;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Loan>> getAllLoans() {
        try {
            List<Loan> loans = loanPort.findAll();
            return ResponseEntity.ok(loans);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        try {
            Optional<Loan> loan = loanPort.findById(id);
            return loan.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        try {
            Loan createdLoan = loanPort.save(loan);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        try {
            Optional<Loan> existingLoan = loanPort.findById(id);
            if (existingLoan.isPresent()) {
                loan.setLoanId(id);
                Loan updatedLoan = loanPort.save(loan);
                return ResponseEntity.ok(updatedLoan);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        try {
            Optional<Loan> loan = loanPort.findById(id);
            if (loan.isPresent()) {
                loanPort.delete(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/customer/{customerId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Loan>> getLoansByCustomer(@PathVariable Long customerId) {
        try {
            List<Loan> loans = loanPort.findByCustomerId(customerId);
            return ResponseEntity.ok(loans);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Loan>> getLoansByStatus(@PathVariable String status) {
        try {
            List<Loan> loans = loanPort.findByStatus(status);
            return ResponseEntity.ok(loans);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{id}/payment")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Loan> makeLoanPayment(@PathVariable Long id, @RequestParam Double amount) {
        try {
            Optional<Loan> loan = loanPort.findById(id);
            if (loan.isPresent()) {
                Loan loanData = loan.get();
                loanData.setBalanceDue(loanData.getBalanceDue() - amount);
                if (loanData.getBalanceDue() <= 0) {
                    loanData.setStatus("PAID");
                }
                Loan updatedLoan = (Loan) loanPort.save(loanData);
                return ResponseEntity.ok(updatedLoan);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
