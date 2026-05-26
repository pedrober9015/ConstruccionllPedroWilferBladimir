package app.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.BankAccountEntity;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, String> {

    // Buscar cuenta por numero
    Optional<BankAccountEntity> findByAccountNumber(String accountNumber);

    // Validar si existe la cuenta
    boolean existsByAccountNumber(String accountNumber);
}
