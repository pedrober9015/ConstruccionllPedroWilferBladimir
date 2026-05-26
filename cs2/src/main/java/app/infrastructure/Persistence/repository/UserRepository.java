package app.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Buscar usuario por documento
    Optional<UserEntity> findByIdentification(String identification);

    // Buscar usuario por correo
    Optional<UserEntity> findByEmail(String email);

    // Validar si existe documento
    boolean existsByIdentification(String identification);

    // Validar si existe correo
    boolean existsByEmail(String email);
}
