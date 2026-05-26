package app.adapter.in.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import app.domain.model.Customer;
import app.domain.ports.CustomerPort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class CustomerController {

    private final CustomerPort customerPort;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        try {
            List<Customer> customers = customerPort.findAll();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable String id) {
        try {
            Optional<Customer> customer =
                    customerPort.findById(id);
            return customer.map(ResponseEntity::ok)
                    .orElseGet(() ->
                            ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Customer> createCustomer(
            @RequestBody Customer customer) {
        try {
            Customer createdCustomer =
                    customerPort.save(customer);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer customer) {
        try {
            Optional<Customer> existingCustomer =
                    customerPort.findById(id);
            if (existingCustomer.isPresent()) {
                customer.setId(id);
                Customer updatedCustomer =
                        customerPort.save(customer);
                return ResponseEntity.ok(updatedCustomer);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable String id) {
        try {
            Optional<Customer> customer =
                    customerPort.findById(id);
            if (customer.isPresent()) {
                customerPort.delete(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}/accounts")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<?> getCustomerAccounts(
            @PathVariable String id) {
        try {
            Optional<Customer> customer =
                    customerPort.findById(id);
            if (customer.isPresent()) {
                return ResponseEntity.ok(
                        customer.get().getAccounts());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}