package app.infrastructure.Persistence.mapper;

import app.domain.model.BankAccount;
import app.infrastructure.Persistence.entities.BankAccountEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de infraestructura entre {@link BankAccount} y {@link BankAccountEntity}.
 *
 * Ofrece dos variantes de toDomain para manejar la referencia bidireccional
 * entre BankAccount y Customer sin caer en recursión infinita:
 *
 *   - {@link #toDomain(BankAccountEntity)}         → incluye la resolución del owner
 *                                                     (el repositorio debe inyectarlo después)
 *   - {@link #toDomainWithoutOwner(BankAccountEntity)} → usado internamente desde CustomerEntityMapper
 */
public class BankAccountEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio completo.
     * El campo {@code owner} NO se resuelve aquí; el repositorio de BankAccount
     * debe llamar al repositorio de Customer para asignarlo tras este mapeo.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio sin owner asignado
     */
    public static BankAccount toDomain(BankAccountEntity entity) {
        if (entity == null) return null;

        BankAccount domain = new BankAccount();
        domain.setAccountNumber(entity.getAccountNumber());
        domain.setAccountType(entity.getAccountType());
        domain.setStatus(entity.getStatus());
        domain.setBalance(entity.getBalance());
        domain.setAvailableBalance(entity.getAvailableBalance());
        domain.setCurrency(entity.getCurrency());
        domain.setOpeningDate(entity.getOpeningDate());
        domain.setLastTransactionDate(entity.getLastTransactionDate());
        // owner se resuelve en el repositorio usando ownerCustomerCode

        // Transferencias salientes
        if (entity.getTransfers() != null) {
            entity.getTransfers().forEach(t ->
                    domain.addTransfer(TransferEntityMapper.toDomainWithoutAccounts(t)));
        }

        return domain;
    }

    /**
     * Igual que {@link #toDomain} pero además omite las transferencias.
     * Se usa cuando el mapeo viene desde CustomerEntityMapper para evitar
     * el ciclo: Customer → BankAccount → Transfer → BankAccount.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio sin owner ni transferencias
     */
    public static BankAccount toDomainWithoutOwner(BankAccountEntity entity) {
        if (entity == null) return null;

        BankAccount domain = new BankAccount();
        domain.setAccountNumber(entity.getAccountNumber());
        domain.setAccountType(entity.getAccountType());
        domain.setStatus(entity.getStatus());
        domain.setBalance(entity.getBalance());
        domain.setAvailableBalance(entity.getAvailableBalance());
        domain.setCurrency(entity.getCurrency());
        domain.setOpeningDate(entity.getOpeningDate());
        domain.setLastTransactionDate(entity.getLastTransactionDate());
        // owner y transfers se omiten para romper el ciclo

        return domain;
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     * Si el dominio tiene un owner asignado, se extrae su customerCode
     * para poblar la FK {@code ownerCustomerCode}.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static BankAccountEntity toEntity(BankAccount domain) {
        if (domain == null) return null;

        BankAccountEntity entity = new BankAccountEntity();
        entity.setAccountNumber(domain.getAccountNumber());
        entity.setAccountType(domain.getAccountType());
        entity.setStatus(domain.getStatus());
        entity.setBalance(domain.getBalance());
        entity.setAvailableBalance(domain.getAvailableBalance());
        entity.setCurrency(domain.getCurrency());
        entity.setOpeningDate(domain.getOpeningDate());
        entity.setLastTransactionDate(domain.getLastTransactionDate());

        if (domain.getOwner() != null) {
            entity.setOwnerCustomerCode(domain.getOwner().getCustomerCode());
        }

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     * No modifica {@code ownerCustomerCode} porque el propietario es inmutable.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(BankAccount domain, BankAccountEntity entity) {
        if (domain == null || entity == null) return;

        entity.setAccountType(domain.getAccountType());
        entity.setStatus(domain.getStatus());
        entity.setBalance(domain.getBalance());
        entity.setAvailableBalance(domain.getAvailableBalance());
        entity.setCurrency(domain.getCurrency());
        entity.setOpeningDate(domain.getOpeningDate());
        entity.setLastTransactionDate(domain.getLastTransactionDate());
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<BankAccount> toDomainList(List<BankAccountEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream()
                .map(BankAccountEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
