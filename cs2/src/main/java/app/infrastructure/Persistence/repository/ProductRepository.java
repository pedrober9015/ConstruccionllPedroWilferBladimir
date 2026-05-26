package app.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    // Buscar producto por nombre
    Optional<ProductEntity> findByName(String name);
}
