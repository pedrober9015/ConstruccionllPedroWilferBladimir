package app.adapter.in.controllers;

import app.domain.model.User;
import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;

public class UserController {
       private User user;

    // Constructor
    public UserController(User user) {
        this.user = user;
    }

    // Login controller
    public void loginUser(String email, String password) {

        boolean success = user.Login(email, password);

        if (success) {
            System.out.println("Login successful.");
            System.out.println("Welcome user with role: " + user.getRolesystem());
        } else {
            System.out.println("Invalid credentials or inactive user.");
        }
    }

    // Logout controller
    public void logoutUser() {
        user.Logout();
    }

    // Update user information
    public void updateUserInformation(String telephone, String direction) {

        user.updateData(telephone, direction);

        System.out.println("User information updated successfully.");
    }

    // Change user status
    public void updateUserStatus(EstatUser newStatus) {

        user.changeEstatus(newStatus);

        System.out.println("User status updated to: " + newStatus);
    }

    // Change user role
    public void updateUserRole(RoleSystem newRole) {

        user.changeRole(newRole);

        System.out.println("User role updated to: " + newRole);
    }

    // Display user information
    public void showUserInformation() {

        System.out.println("===== USER INFORMATION =====");
        System.out.println("Role: " + user.getRolesystem());
        System.out.println("Status: " + user.getEstatUser());
    }
}
