package app.domain.model;

import java.time.LocalDate;

import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;

public class User {

    private String iduser;
    private int idrelation;
    private String fullname;
    private String ididenfication;
    private String email;
    private String telephone;
    private LocalDate datebirth;
    private String direction;
    private RoleSystem rolsystem;
    private EstatUser estatUser;
    private String password;

    // Constructor vacío
    public User() {
    }

    // Constructor completo
    public User(String iduser, int idrelation, String fullname,
                String ididenfication, String email, String telephone,
                LocalDate datebirth, String direction,
                RoleSystem rolsystem, EstatUser estatUser,
                String password) {

        this.iduser = iduser;
        this.idrelation = idrelation;
        this.fullname = fullname;
        this.ididenfication = ididenfication;
        this.email = email;
        this.telephone = telephone;
        this.datebirth = datebirth;
        this.direction = direction;
        this.rolsystem = rolsystem;
        this.estatUser = estatUser;
        this.password = password;
    }

    // Login
    public boolean login(String email, String password) {
        return this.email.equals(email)
                && this.password.equals(password)
                && this.estatUser == EstatUser.ACTIVE;
    }

    // Logout
    public void logout() {
        System.out.println("User logged out: " + this.fullname);
    }

    // Update data
    public void updateData(String telephone, String direction) {
        this.telephone = telephone;
        this.direction = direction;

        System.out.println("User data updated: " + this.fullname);
    }

    // Change status
    public void changeEstatus(EstatUser newEstatus) {
        this.estatUser = newEstatus;
    }

    // Change role
    public void changeRole(RoleSystem newRole) {
        this.rolsystem = newRole;
    }

    // Getters

    public String getIduser() {
        return iduser;
    }

    public int getIdrelation() {
        return idrelation;
    }

    public String getFullname() {
        return fullname;
    }

    public String getIdidenfication() {
        return ididenfication;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getDatebirth() {
        return datebirth;
    }

    public String getDirection() {
        return direction;
    }

    public RoleSystem getRolesystem() {
        return rolsystem;
    }

    public EstatUser getEstatUser() {
        return estatUser;
    }

    public String getPassword() {
        return password;
    }

    // Setters

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public void setIdrelation(int idrelation) {
        this.idrelation = idrelation;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setIdidenfication(String ididenfication) {
        this.ididenfication = ididenfication;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setDatebirth(LocalDate datebirth) {
        this.datebirth = datebirth;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setRolesystem(RoleSystem rolsystem) {
        this.rolsystem = rolsystem;
    }

    public void setEstatUser(EstatUser estatUser) {
        this.estatUser = estatUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}