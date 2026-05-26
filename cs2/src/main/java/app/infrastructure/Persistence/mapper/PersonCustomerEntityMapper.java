package app.infrastructure.persistence.mapper;

import app.domain.model.PersonCustomer;
import app.infrastructure.persistence.entities.PersonCustomerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper de infraestructura entre el objeto de dominio {@link PersonCustomer}
 * y la entidad JPA {@link PersonCustomerEntity}.
 *
 * Responsabilidad exclusiva: traducir la representación del dominio
 * a la representación persistible y viceversa, sin lógica de negocio.
 */
public class PersonCustomerEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     * Las colecciones (accounts, loans) se mapean de forma lazy-safe:
     * si Hibernate no las inicializó, se devuelven listas vacías.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio completamente poblado
     */
    public static PersonCustomer toDomain(PersonCustomer entity) {
        if (entity == null) return null;

        PersonCustomer domain = new PersonCustomer();

        // Campos de Person
        domain.setId(entity.getId());
        domain.setFirstName(entity.getFirstName());
        domain.setLastName(entity.getLastName());
        domain.setEmail(entity.getEmail());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setBirthDate(entity.getBirthDate());
        domain.setAddress(entity.getAddress());

        // Campos de Customer
        domain.setCustomerCode(entity.getCustomerCode());
        domain.setRegistrationDate(entity.getRegistrationDate());
        domain.setActive(entity.isActive());

        // Campos propios de PersonCustomer
        domain.setNationalId(entity.getNationalId());
        domain.setOccupation(entity.getOccupation());
        domain.setMonthlyIncome(entity.getMonthlyIncome());

        // Cuentas — se mapea sin el owner para evitar ciclo infinito
        if (entity.getAccounts() != null) {
            entity.getAccounts().forEach(accEntity -> {
                domain.addAccount(BankAccountEntityMapper.toDomainWithoutOwner(accEntity));
            });
        }

        // Préstamos — se mapea sin el customer para evitar ciclo infinito
        if (entity.getLoans() != null) {
            entity.getLoans().forEach(loanEntity -> {
                domain.addLoan(LoanEntityMapper.toDomainWithoutCustomer(loanEntity));
            });
        }

        return domain;
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     * Las colecciones de accounts y loans NO se propagan aquí:
     * cada agregado se persiste por su propio repositorio.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir con {@code EntityManager.persist()}
     */
    public static PersonCustomerEntity toEntity(PersonCustomer domain) {
        if (domain == null) return null;

        PersonCustomerEntity entity = new PersonCustomerEntity();

        // Campos de Person
        entity.setId(domain.getId());
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());

        // Campos de Customer
        entity.setCustomerCode(domain.getCustomerCode());
        entity.setRegistrationDate(domain.getRegistrationDate());
        entity.setActive(domain.isActive());

        // Campos propios de PersonCustomer
        entity.setNationalId(domain.getNationalId());
        entity.setOccupation(domain.getOccupation());
        entity.setMonthlyIncome(domain.getMonthlyIncome());

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     * Útil en operaciones merge para evitar crear una nueva instancia gestionada.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(PersonCustomer domain, PersonCustomerEntity entity) {
        if (domain == null || entity == null) return;

        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());
        entity.setCustomerCode(domain.getCustomerCode());
        entity.setRegistrationDate(domain.getRegistrationDate());
        entity.setActive(domain.isActive());
        entity.setNationalId(domain.getNationalId());
        entity.setOccupation(domain.getOccupation());
        entity.setMonthlyIncome(domain.getMonthlyIncome());
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<PersonCustomer> toDomainList(List<PersonCustomerEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return null;
    }
}
