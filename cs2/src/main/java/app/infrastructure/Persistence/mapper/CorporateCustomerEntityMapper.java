package app.infrastructure.Persistence.mapper;

import app.domain.model.CorporateCustomer;
import app.infrastructure.Persistence.entities.CorporateCustomerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de infraestructura entre {@link CorporateCustomer} y {@link CorporateCustomerEntity}.
 */
public class CorporateCustomerEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio completamente poblado
     */
    public static CorporateCustomer toDomain(CorporateCustomerEntity entity) {
        if (entity == null) return null;

        CorporateCustomer domain = new CorporateCustomer();

        // Campos de Person
        domain.setId(entity.getId());
        domain.setFirstName(entity.getFirstName());
        domain.setLastName(entity.getCompanyName());
        domain.setEmail(entity.getEmail());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setBirthDate(entity.getBirthDate());
        domain.setAddress(entity.getClass());

        // Campos de Customer
        domain.setCustomerCode(entity.getCustomerCode());
        domain.setRegistrationDate(entity.getRegistrationDate());
        domain.setActive(entity.isActive());

        // Campos propios de CorporateCustomer
        domain.setTaxId(entity.getTaxId());
        domain.setCompanyName(entity.getCompanyName());
        domain.setLegalRepresentative(entity.getLegalRepresentative());
        domain.setBusinessSector(entity.getBusinessSector());
        domain.setAnnualRevenue(entity.getAnnualRevenue());

        // Cuentas asociadas (sin owner para evitar ciclo)
        if (entity.getAccounts() != null) {
            entity.getAccounts().forEach(accEntity ->
                    domain.addAccount(BankAccountEntityMapper.toDomainWithoutOwner(accEntity)));
        }

        // Préstamos asociados (sin customer para evitar ciclo)
        if (entity.getLoans() != null) {
            entity.getLoans().forEach(loanEntity ->
                    domain.addLoan(LoanEntityMapper.toDomainWithoutCustomer(loanEntity)));
        }

        return domain;
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static CorporateCustomerEntity toEntity(CorporateCustomer domain) {
        if (domain == null) return null;

        CorporateCustomerEntity entity = new CorporateCustomerEntity();

        // Campos de Person
        entity.setId(domain.getId());
        entity.setFirstName(domain.getFirstName());
        entity.setCompanyName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());

        // Campos de Customer
        entity.setCustomerCode(domain.getCustomerCode());
        entity.setRegistrationDate(domain.getRegistrationDate());
        entity.setActive(domain.isActive());

        // Campos propios de CorporateCustomer
        entity.setTaxId(domain.getTaxId());
        entity.setCompanyName(domain.getCompanyName());
        entity.setLegalRepresentative(domain.getLegalRepresentative());
        entity.setBusinessSector(domain.getBusinessSector());
        entity.setAnnualRevenue(domain.getAnnualRevenue());

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(CorporateCustomer domain, CorporateCustomerEntity entity) {
        if (domain == null || entity == null) return;

        entity.setFirstName(domain.getFirstName());
        entity.setCompanyName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());
        entity.setCustomerCode(domain.getCustomerCode());
        entity.setRegistrationDate(domain.getRegistrationDate());
        entity.setActive(domain.isActive());
        entity.setTaxId(domain.getTaxId());
        entity.setCompanyName(domain.getCompanyName());
        entity.setLegalRepresentative(domain.getLegalRepresentative());
        entity.setBusinessSector(domain.getBusinessSector());
        entity.setAnnualRevenue(domain.getAnnualRevenue());
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<CorporateCustomer> toDomainList(List<CorporateCustomerEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream()
                .map(CorporateCustomerEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
