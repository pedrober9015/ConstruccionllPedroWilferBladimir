package app.adapter.in.bulders;

import java.time.LocalDate;

import app.domain.model.User;
import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;

public class UserBuilder {

    private int iduser;
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

    public UserBuilder setIduser(int iduser) {
        this.iduser = iduser;
        return this;
    }

    public UserBuilder setIdrelation(int idrelation) {
        this.idrelation = idrelation;
        return this;
    }

    public UserBuilder setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public UserBuilder setIdidenfication(String ididenfication) {
        this.ididenfication = ididenfication;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public UserBuilder setDatebirth(LocalDate datebirth) {
        this.datebirth = datebirth;
        return this;
    }

    public UserBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public UserBuilder setRolesystem(RoleSystem rolsystem) {
        this.rolsystem = rolsystem;
        return this;
    }

    public UserBuilder setEstatUser(EstatUser estatUser) {
        this.estatUser = estatUser;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(
            iduser,
            idrelation,
            fullname,
            ididenfication,
            email,
            telephone,
            datebirth,
            direction,
            rolsystem,
            estatUser,
            password
        );
    }
}
