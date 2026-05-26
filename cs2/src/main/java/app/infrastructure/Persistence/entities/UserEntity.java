package app.infrastructure.persistence.entities;

import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {

    // ID DEL USUARIO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    // ID RELACIONADO CON OTRA ENTIDAD
    @Column(name = "id_relation")
    private Long idRelation;

    // NOMBRE COMPLETO
    @Column(name = "fullname", nullable = false, length = 200)
    private String fullName;

    // DOCUMENTO DE IDENTIFICACION
    @Column(name = "id_identification", unique = true, length = 30)
    private String identification;

    // CORREO ELECTRONICO
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    // TELEFONO
    @Column(name = "telephone", length = 20)
    private String telephone;

    // FECHA DE NACIMIENTO
    @Column(name = "date_birth")
    private LocalDate dateBirth;

    // DIRECCION
    @Column(name = "direction", length = 255)
    private String direction;

    // ROL DEL SISTEMA
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_system", nullable = false, length = 30)
    private RoleSystem roleSystem;

    // ESTADO DEL USUARIO
    @Enumerated(EnumType.STRING)
    @Column(name = "estat_user", nullable = false, length = 20)
    private EstatUser estatUser;

    // CONTRASEÑA
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public UserEntity() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(Long idRelation) {
        this.idRelation = idRelation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public RoleSystem getRoleSystem() {
        return roleSystem;
    }

    public void setRoleSystem(RoleSystem roleSystem) {
        this.roleSystem = roleSystem;
    }

    public EstatUser getEstatUser() {
        return estatUser;
    }

    public void setEstatUser(EstatUser estatUser) {
        this.estatUser = estatUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}