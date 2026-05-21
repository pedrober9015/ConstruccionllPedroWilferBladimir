package app.domain.Services;

import java.util.List;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class UserService {

    private final UserPort userPort;

    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    // VERIFICAR SI EXISTE DOCUMENTO
    public boolean existsByDocument(String identification) {
        return userPort.existsByDocument(identification);
    }

    // VERIFICAR SI EXISTE NOMBRE DE USUARIO
    public boolean existsByUserName(String userName) {
        return userPort.existsByUserName(userName);
    }

    // VERIFICAR SI EXISTE EMAIL
    public boolean existsByEmail(String email) {
        return userPort.existsByEmail(email);
    }

    // BUSCAR USUARIO POR DOCUMENTO
    public User findByDocument(String identification) {
        return userPort.findByDocument(identification);
    }

    // BUSCAR USUARIO POR USERNAME
    public User findByUserName(String userName) {
        return userPort.findByUserName(userName);
    }

    // OBTENER TODOS LOS USUARIOS
    public List<User> findAll() {
        return userPort.findAll();
    }

    // GUARDAR USUARIO
    public User save(User user) {
        return userPort.save(user);
    }

    // ACTUALIZAR USUARIO
    public void update(User user) {
        userPort.update(user);
    }

    // ELIMINAR USUARIO
    public void deleteByDocument(String identification) {
        userPort.deleteByDocument(identification);
    }
}