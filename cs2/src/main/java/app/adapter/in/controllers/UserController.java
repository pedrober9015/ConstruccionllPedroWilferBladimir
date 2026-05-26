package app.adapter.in.controllers;

import app.domain.model.User;
import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class UserController {

    private final User user;
    
    // Login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @RequestParam String email,
            @RequestParam String password) {
        try {
            boolean success = user.login(email, password);
            if (success) {
                return ResponseEntity.ok(
                        "Login successful. Welcome user with role: "
                                + user.getRolesystem());
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials or inactive user.");
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during login.");
        }
    }
    // Logout
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {

        try {
            user.logout();
            return ResponseEntity.ok(
                    "User logged out successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during logout.");
        }
    }
    // Update user information
    @PutMapping("/update-info")
    public ResponseEntity<String> updateUserInformation(
            @RequestParam String telephone,
            @RequestParam String direction) {
        try {
            user.updateData(telephone, direction);
            return ResponseEntity.ok(
                    "User information updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST)
                    .body("Error updating user information.");
        }
    }
    // Change user status
    @PutMapping("/status")
    public ResponseEntity<String> updateUserStatus(
            @RequestParam EstatUser newStatus) {
        try {
            user.changeEstatus(newStatus);
            return ResponseEntity.ok(
                    "User status updated to: " + newStatus);
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST)
                    .body("Error updating user status.");
        }
    }
    // Change user role
    @PutMapping("/role")
    public ResponseEntity<String> updateUserRole(
            @RequestParam RoleSystem newRole) {
        try {
            user.changeRole(newRole);
            return ResponseEntity.ok(
                    "User role updated to: " + newRole);
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST)
                    .body("Error updating user role.");
        }
    }
    // Show user information
    @GetMapping("/info")
    public ResponseEntity<String> showUserInformation() {
        try {
            String info =
                    "===== USER INFORMATION =====\n"
                            + "Role: " + user.getRolesystem() + "\n"
                            + "Status: " + user.getEstatUser();
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving user information.");
        }
    }
}