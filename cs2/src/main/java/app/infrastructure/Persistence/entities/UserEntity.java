package app.infrastructure.Persistence.entities;

import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private String  iduser;

    @Column(name = "id_relation")
    private int idrelation;

    @Column(name = "fullname", nullable = false, length = 200)
    private String fullname;

    @Column(name = "id_identification", unique = true, length = 30)
    private String ididenfication;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "date_birth")
    private LocalDate datebirth;

    @Column(name = "direction", length = 255)
    private String direction;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_system", nullable = false, length = 30)
    private RoleSystem rolsystem;

    @Enumerated(EnumType.STRING)
    @Column(name = "estat_user", nullable = false, length = 20)
    private EstatUser estatUser;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public UserEntity() {}

    public  String getIduser() { return iduser; }
    public void setIduser(String iduser) { this.iduser = iduser; }

    public int getIdrelation() { return idrelation; }
    public void setIdrelation(int idrelation) { this.idrelation = idrelation; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getIdidenfication() { return ididenfication; }
    public void setIdidenfication(String ididenfication) { this.ididenfication = ididenfication; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public LocalDate getDatebirth() { return datebirth; }
    public void setDatebirth(LocalDate datebirth) { this.datebirth = datebirth; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public RoleSystem getRolsystem() { return rolsystem; }
    public void setRolsystem(RoleSystem rolsystem) { this.rolsystem = rolsystem; }

    public EstatUser getEstatUser() { return estatUser; }
    public void setEstatUser(EstatUser estatUser) { this.estatUser = estatUser; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
