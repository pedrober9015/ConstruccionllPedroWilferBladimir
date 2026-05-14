package app.domain.ports;

import java.util.List;
import app.domain.model.User;

public interface UserPort {

    // VERIFICAR SI EXISTE DOCUMENTO
    public boolean existsByDocument(String identification);

    // VERIFICAR SI EXISTE USERNAME
    public boolean existsByUserName(String userName);

    // VERIFICAR SI EXISTE EMAIL
    public boolean existsByEmail(String email);

    // BUSCAR USUARIO POR DOCUMENTO
    public User findByDocument(String identification);

    // BUSCAR USUARIO POR USERNAME
    public User findByUserName(String userName);

    // OBTENER TODOS LOS USUARIOS
   public List<User> findAll();

    // GUARDAR USUARIO
    public User save(User user);

    // ACTUALIZAR USUARIO
     public void update(User user);

    // ELIMINAR USUARIO
    public void deleteByDocument(String identification);
}