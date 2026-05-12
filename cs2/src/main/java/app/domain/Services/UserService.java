package app.domain.Services;
import java.util.List;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class UserService {

    private final UserPort userPort;


    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    public boolean existsByDocument(String identification) {
        return userPort.existisByDocument(identification);
    }

    public boolean existsByUserName(String userName) {
        return userPort.existisByUserName(userName);
    }

    public boolean existsByEmail(String email) {
        return userPort.existsByEmail(email);
    }

    public User findByDocument(String identification) {
        return userPort.findByDocument(identification);
    }


    public User findByUserName(String userName) {
        return userPort.findByUserName(userName);
    }

    public List<User> findAll() {
        return userPort.findAll();
    }

    public User save(User user) {
        return userPort.save(user);
    }

    public void update(User user) {
        userPort.update(user);
    }

    public void deleteByDocument(String identification) {
        userPort.deleteByDocument(identification);
    }
}