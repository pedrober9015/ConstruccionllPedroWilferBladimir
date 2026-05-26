package app.infrastructure.persistence.mapper;

import app.domain.model.CorporateCustomer;
import app.infrastructure.persistence.entities.CorporateCustomerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CorporateCustomerEntityMapper {

    public static CorporateCustomer toDomain(CorporateCustomerEntity entity) {
        if (entity == null) return null;

        CorporateCustomer domain = new CorporateCustomer();

        // PERSON
        domain.setId(entity.getId());
        domain.setFirstName(entity.getFirstName());
        domain.setLastName(entity.getLastName());
        domain.setEmail(entity.getEmail());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setBirthDate(entity.getBirthDate());
        domain.setAddress(entity.getAddress());

        // CUSTOMER
        domain.setCustomerCode(entity.getCustomerCode());
        domain.setRegistrationDate(entity.getRegistrationDate());
        domain.setActive(entity.isActive());

        // CORPORATE
        domain.setTaxId(entity.getTaxId());
        domain.setCompanyName(entity.getCompanyName());
        domain.setLegalRepresentative(entity.getLegalRepresentative());
        domain.setBusinessSector(entity.getBusinessSector());
        domain.setAnnualRevenue(entity.getAnnualRevenue());

        return domain;
    }

    public static CorporateCustomerEntity toEntity(CorporateCustomer domain) {
        if (domain == null) return null;

        CorporateCustomerEntity entity = new CorporateCustomerEntity();

        // PERSON
        entity.setId(domain.getId());
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());

        // CUSTOMER
        entity.setCustomerCode(domain.getCustomerCode());
        entity.setRegistrationDate(domain.getRegistrationDate());
        entity.setActive(domain.isActive());

        // CORPORATE
        entity.setTaxId(domain.getTaxId());
        entity.setCompanyName(domain.getCompanyName());
        entity.setLegalRepresentative(domain.getLegalRepresentative());
        entity.setBusinessSector(domain.getBusinessSector());
        entity.setAnnualRevenue(domain.getAnnualRevenue());

        return entity;
    }

    public static void updateEntity(CorporateCustomer domain, CorporateCustomerEntity entity) {
        if (domain == null || entity == null) return;

        // PERSON
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());

        // CUSTOMER
        entity.setCustomerCode(domain.getCustomerCode());
        entity.setRegistrationDate(domain.getRegistrationDate());
        entity.setActive(domain.isActive());

        // CORPORATE
        entity.setTaxId(domain.getTaxId());
        entity.setCompanyName(domain.getCompanyName());
        entity.setLegalRepresentative(domain.getLegalRepresentative());
        entity.setBusinessSector(domain.getBusinessSector());
        entity.setAnnualRevenue(domain.getAnnualRevenue());
    }

    public static List<CorporateCustomer> toDomainList(List<CorporateCustomerEntity> entities) {
        if (entities == null) return new ArrayList<>();

        return entities.stream()
                .map(CorporateCustomerEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}