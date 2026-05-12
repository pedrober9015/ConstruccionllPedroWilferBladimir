package app.application;
import java.util.List;
import app.domain.model.User;
import app.domain.Services.UserService;

public class UserUseCases {

    private final UserService userService;

    public UserUseCases(UserService userService) {
        this.userService = userService;
    }

        // GUARDAR USUARIO
    public User saveUser(User user) {
        return userService.save(user);
    }

    // ACTUALIZAR USUARIO
    public void updateUser(User user) {
        userService.update(user);
    }

    // ELIMINAR USUARIO
    public void deleteUser(String identification) {
        userService.deleteByDocument(identification);
    }

    // BUSCAR USUARIO POR DOCUMENTO
    public User findByDocument(String identification) {
        return userService.findByDocument(identification);
    }

    // BUSCAR USUARIO POR NOMBRE DE USUARIO
    public User findByUserName(String userName) {
        return userService.findByUserName(userName);
    }

    // OBTENER TODOS LOS USUARIOS
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    // VERIFICAR SI EXISTE EL DOCUMENTO
    public boolean existsByDocument(String identification) {
        return userService.existsByDocument(identification);
    }

    // VERIFICAR SI EXISTE EL NOMBRE DE USUARIO
    public boolean existsByUserName(String userName) {
        return userService.existsByUserName(userName);
    }

    // VERIFICAR SI EXISTE EL CORREO ELECTRONICO
    public boolean existsByEmail(String email) {
        return userService.existsByEmail(email);
    }
}
