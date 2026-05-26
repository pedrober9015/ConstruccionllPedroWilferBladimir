package app.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.PersonCustomerEntity;

public interface PersonCustomerRepository extends JpaRepository<PersonCustomerEntity, String> {

    // Buscar cliente por codigo
    Optional<PersonCustomerEntity> findByCustomerCode(String customerCode);

    // Buscar cliente por documento
    Optional<PersonCustomerEntity> findByNationalId(String nationalId);
}