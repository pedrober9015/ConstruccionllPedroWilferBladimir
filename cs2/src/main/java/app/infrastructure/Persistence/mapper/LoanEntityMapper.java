package app.infrastructure.Persistence.mapper;

import app.domain.model.Loan;
import app.infrastructure.Persistence.entities.LoanEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper de infraestructura entre {@link Loan} y {@link LoanEntity}.
 *
 * El ciclo Loan → Customer → List&lt;Loan&gt; se corta con dos variantes:
 *   - {@link #toDomain}                   → usado en el repositorio de Loan
 *   - {@link #toDomainWithoutCustomer}    → usado desde CustomerEntityMapper
 */
public class LoanEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     * El campo {@code customer} NO se resuelve aquí;
     * el repositorio de Loan lo asigna tras este mapeo.
     *
     * @param loanEntity entidad JPA; si es null retorna null
     * @return objeto de dominio sin customer asignado
     */
    public static Loan toDomain(Loan loanEntity) {
        if (loanEntity == null) return null;

        Loan domain = new Loan();
        domain.setLoanId(loanEntity.getLoanId());
        domain.setPrincipal(loanEntity.getPrincipal());
        domain.setInterestRate(loanEntity.getInterestRate());
        domain.setTermMonths(loanEntity.getTermMonths());
        domain.setMonthlyPayment(loanEntity.getMonthlyPayment());
        domain.setRemainingBalance(loanEntity.getRemainingBalance());
        domain.setStatus(loanEntity.getStatus());
        domain.setStartDate(loanEntity.getStartDate());
        domain.setEndDate(loanEntity.getEndDate());
        domain.setNextPaymentDate(loanEntity.getNextPaymentDate());
        domain.setPurpose(loanEntity.getPurpose());
        // customer se resuelve en el repositorio

        return domain;
    }

    /**
     * Alias semántico de {@link #toDomain}. Llamado desde los mappers de Customer
     * para dejar explícita la intención de no resolver el customer (evitar ciclo).
     *
     * @param loanEntity entidad JPA; si es null retorna null
     * @return objeto de dominio sin customer asignado
     */
    public static Loan toDomainWithoutCustomer(Loan loanEntity) {
        return toDomain(loanEntity);
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     * Si el dominio tiene un customer asignado, se extrae su código y tipo
     * para poblar los campos discriminadores de la entidad.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static LoanEntity toEntity(Loan domain) {
        if (domain == null) return null;

        LoanEntity entity = new LoanEntity();
        entity.setLoanId(domain.getLoanId());
        entity.setPrincipal(domain.getPrincipal());
        entity.setInterestRate(domain.getInterestRate());
        entity.setTermMonths(domain.getTermMonths());
        entity.setMonthlyPayment(domain.getMonthlyPayment());
        entity.setRemainingBalance(domain.getRemainingBalance());
        entity.setStatus(domain.getStatus());
        entity.setStartDate(domain.getStartDate());
        entity.setEndDate(domain.getEndDate());
        entity.setNextPaymentDate(domain.getNextPaymentDate());
        entity.setPurpose(domain.getPurpose());

        if (domain.getCustomer() != null) {
            entity.setCustomerCode(domain.getCustomer().getCustomerCode());
            entity.setCustomerType(domain.getCustomer().getCustomerType());
        }

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     * No modifica los campos de customer ya que el préstamo es inmutable
     * respecto a su titular una vez creado.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(Loan domain, LoanEntity entity) {
        if (domain == null || entity == null) return;

        entity.setPrincipal(domain.getPrincipal());
        entity.setInterestRate(domain.getInterestRate());
        entity.setTermMonths(domain.getTermMonths());
        entity.setMonthlyPayment(domain.getMonthlyPayment());
        entity.setRemainingBalance(domain.getRemainingBalance());
        entity.setStatus(domain.getStatus());
        entity.setStartDate(domain.getStartDate());
        entity.setEndDate(domain.getEndDate());
        entity.setNextPaymentDate(domain.getNextPaymentDate());
        entity.setPurpose(domain.getPurpose());
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<Loan> toDomainList(List<LoanEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return null;
    }

    public static Loan toDomainWithoutCustomer(LoanEntity loanEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDomainWithoutCustomer'");
    }
}
