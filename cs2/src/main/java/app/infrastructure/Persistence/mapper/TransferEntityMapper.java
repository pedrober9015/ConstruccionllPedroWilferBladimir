package app.infrastructure.Persistence.mapper;

import app.domain.model.Transfer;
import app.infrastructure.Persistence.entities.BankAccountEntity;
import app.infrastructure.Persistence.entities.TransferEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de infraestructura entre {@link Transfer} y {@link TransferEntity}.
 *
 * Las referencias a BankAccount dentro de Transfer generan un ciclo:
 *   Transfer → BankAccount → List&lt;Transfer&gt; → Transfer…
 *
 * Para cortarlo se ofrecen dos variantes de toDomain:
 *   - {@link #toDomain}                  → resuelve sourceAccount y destinationAccount
 *                                           (el repositorio los inyecta tras el mapeo)
 *   - {@link #toDomainWithoutAccounts}   → usado desde BankAccountEntityMapper
 */
public class TransferEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     * Las cuentas origen/destino NO se resuelven aquí;
     * el repositorio de Transfer las asigna después del mapeo.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio sin cuentas asignadas
     */
    public static Transfer toDomain(TransferEntity entity) {
        if (entity == null) return null;

        Transfer domain = new Transfer();
        domain.setTransferId(entity.getTransferId());
        domain.setAmount(entity.getAmount());
        domain.setCurrency(entity.getCurrency());
        domain.setStatus(entity.getStatus());
        domain.setDescription(entity.getDescription());
        domain.setTransferDate(entity.getTransferDate());
        domain.setReferenceCode(entity.getReferenceCode());
        // sourceAccount y destinationAccount se resuelven en el repositorio

        return domain;
    }

    /**
     * Igual que {@link #toDomain} pero explícitamente documenta que
     * las cuentas NO se incluyen. Llamado desde {@link BankAccountEntityMapper}
     * para evitar recursión infinita.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio sin cuentas asignadas
     */
    public static Transfer toDomainWithoutAccounts(TransferEntity entity) {
        return toDomain(entity);   // misma lógica, nombre semántico distinto
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     * Si el dominio tiene cuentas asignadas, se usan para poblar las FK de JPA.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static TransferEntity toEntity(Transfer domain) {
        if (domain == null) return null;

        TransferEntity entity = new TransferEntity();
        entity.setTransferId(domain.getTransferId());
        entity.setAmount(domain.getAmount());
        entity.setCurrency(domain.getCurrency());
        entity.setStatus(domain.getStatus());
        entity.setDescription(domain.getDescription());
        entity.setTransferDate(domain.getTransferDate());
        entity.setReferenceCode(domain.getReferenceCode());

        // Las relaciones ManyToOne se asignan desde el repositorio mediante
        // entityManager.getReference(BankAccountEntity.class, accountNumber)
        // para evitar cargar las entidades completas solo para persistir la FK.
        if (domain.getSourceAccount() != null) {
            BankAccountEntity srcEntity = new BankAccountEntity();
            srcEntity.setAccountNumber(domain.getSourceAccount().getAccountNumber());
            entity.setSourceAccount(srcEntity);
        }

        if (domain.getDestinationAccount() != null) {
            BankAccountEntity dstEntity = new BankAccountEntity();
            dstEntity.setAccountNumber(domain.getDestinationAccount().getAccountNumber());
            entity.setDestinationAccount(dstEntity);
        }

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     * No modifica las cuentas origen/destino ya que son inmutables en una transferencia.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(Transfer domain, TransferEntity entity) {
        if (domain == null || entity == null) return;

        entity.setAmount(domain.getAmount());
        entity.setCurrency(domain.getCurrency());
        entity.setStatus(domain.getStatus());
        entity.setDescription(domain.getDescription());
        entity.setTransferDate(domain.getTransferDate());
        entity.setReferenceCode(domain.getReferenceCode());
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<Transfer> toDomainList(List<TransferEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream()
                .map(TransferEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
