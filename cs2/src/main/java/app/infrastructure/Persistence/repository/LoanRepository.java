package app.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, String> {

    // Buscar prestamo por id
    Optional<LoanEntity> findByLoanId(String loanId);

    // Validar existencia
    boolean existsByLoanId(String loanId);
}
