package app.infrastructure.Persistence.mapper;

import app.domain.model.Bitacora;
import app.infrastructure.Persistence.entities.BitacoraEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de infraestructura entre {@link Bitacora} y {@link BitacoraEntity}.
 * Los registros de auditoría son inmutables por naturaleza: no se provee updateEntity.
 */
public class BitacoraEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio completamente poblado
     */
    public static Bitacora toDomain(BitacoraEntity entity) {
        if (entity == null) return null;

        Bitacora domain = new Bitacora();
        domain.setLogId(entity.getLogId());
        domain.setAction(entity.getAction());
        domain.setEntityType(entity.getEntityType());
        domain.setEntityId(entity.getEntityId());
        domain.setPerformedBy(entity.getPerformedBy());
        domain.setTimestamp(entity.getTimestamp());
        domain.setIpAddress(entity.getIpAddress());
        domain.setDetails(entity.getDetails());
        domain.setSuccess(entity.isSuccess());
        domain.setErrorMessage(entity.getErrorMessage());

        return domain;
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static BitacoraEntity toEntity(Bitacora domain) {
        if (domain == null) return null;

        BitacoraEntity entity = new BitacoraEntity();
        entity.setLogId(domain.getLogId());
        entity.setAction(domain.getAction());
        entity.setEntityType(domain.getEntityType());
        entity.setEntityId(domain.getEntityId());
        entity.setPerformedBy(domain.getPerformedBy());
        entity.setTimestamp(domain.getTimestamp());
        entity.setIpAddress(domain.getIpAddress());
        entity.setDetails(domain.getDetails());
        entity.setSuccess(domain.isSuccess());
        entity.setErrorMessage(domain.getErrorMessage());

        return entity;
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<Bitacora> toDomainList(List<BitacoraEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream()
                .map(BitacoraEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
