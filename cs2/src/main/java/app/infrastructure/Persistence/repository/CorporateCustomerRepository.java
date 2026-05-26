package app.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.CorporateCustomerEntity;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomerEntity, String> {

    // Buscar empresa por codigo
    Optional<CorporateCustomerEntity> findByCustomerCode(String customerCode);

    // Buscar empresa por NIT
    Optional<CorporateCustomerEntity> findByTaxId(String taxId);
}
