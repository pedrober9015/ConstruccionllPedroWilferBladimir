package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.BitacoraEntity;

public interface BitacoraRepository extends JpaRepository<BitacoraEntity, String> {

}