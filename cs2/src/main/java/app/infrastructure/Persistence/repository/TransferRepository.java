package app.infrastructure.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.TransferEntity;

public interface TransferRepository extends JpaRepository<TransferEntity, String> {

    // Buscar transferencias por cuenta origen
    List<TransferEntity> findBySourceAccountAccountNumber(String accountNumber);

    // Buscar transferencias por cuenta destino
    List<TransferEntity> findByDestinationAccountAccountNumber(String accountNumber);
}
