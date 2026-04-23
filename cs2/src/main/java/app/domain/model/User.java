package app.domain.model;

import java.time.LocalDate;

import app.domain.model.enums.EstatUser;
import app.domain.model.enums.RoleSystem;

public class User {
private int iduser;
private int idrelation;
private String fullname;
private String ididenfication;
private String email;
private String telephone;
private LocalDate datebirth;
private String direction;
private RoleSystem rolsystem;
private EstatUser  estatUser;
private String password;

//constructor
    public User(int iduser, int idrelation, String fullname, String ididenfication, String email, String telephone,
        LocalDate datebirth, String direction, RoleSystem rolsystem, EstatUser estatUser, String password) {
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
//login 
public boolean Login(String email, String password){
   return this.email.equals(email) && 
   this.password.equals(password) && 
   this.estatUser == EstatUser.ACTIVE;

}
//logout
public void Logout(){
    System.out.println("User logged out: "+ this.fullname); 
}

//update data
public void updateData(String telephone , String direction){
    this.telephone = telephone;
    this.direction = direction;
    System.out.println("User data updated: "+ this.fullname);
}

//change estatus
public void changeEstatus(EstatUser newEstatus){
    this.estatUser= newEstatus;

}

//role
public void changeRole(RoleSystem newRole){
    this.rolsystem = newRole;
}
 //getters
    public RoleSystem getRolesystem() {
        return rolsystem;
    }
    public EstatUser getEstatUser() {
        return estatUser;
    }
}
