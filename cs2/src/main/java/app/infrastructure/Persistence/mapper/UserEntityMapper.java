package app.infrastructure.Persistence.mapper;

import app.domain.model.User;
import app.infrastructure.Persistence.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de infraestructura entre {@link User} y {@link UserEntity}.
 * A diferencia del UserMapper de aplicación, aquí SÍ se propaga el password
 * porque esta capa trata directamente con la base de datos.
 */
public class UserEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     * Incluye el password hasheado tal como está almacenado en BD.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio completamente poblado
     */
    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
                entity.getIduser(),
                entity.getIdrelation(),
                entity.getFullname(),
                entity.getIdidenfication(),
                entity.getEmail(),
                entity.getTelephone(),
                entity.getDatebirth(),
                entity.getDirection(),
                entity.getRolsystem(),
                entity.getEstatUser(),
                entity.getPassword()
        );
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;

        UserEntity entity = new UserEntity();
        entity.setIduser(domain.getIduser());
        entity.setIdrelation(domain.getIdrelation());
        entity.setFullname(domain.getFullname());
        entity.setIdidenfication(domain.getIdidenfication());
        entity.setEmail(domain.getEmail());
        entity.setTelephone(domain.getTelephone());
        entity.setDatebirth(domain.getDatebirth());
        entity.setDirection(domain.getDirection());
        entity.setRolsystem(domain.getRolesystem());
        entity.setEstatUser(domain.getEstatUser());
        entity.setPassword(domain.getPassword());

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     * Solo propaga los campos que pueden cambiar (teléfono, dirección, rol, estado).
     * El password se actualiza únicamente si no es null, para evitar borrados accidentales.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(User domain, UserEntity entity) {
        if (domain == null || entity == null) return;

        entity.setTelephone(domain.getTelephone());
        entity.setDirection(domain.getDirection());
        entity.setRolsystem(domain.getRolesystem());
        entity.setEstatUser(domain.getEstatUser());
        entity.setFullname(domain.getFullname());

        if (domain.getPassword() != null && !domain.getPassword().isBlank()) {
            entity.setPassword(domain.getPassword());
        }
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<User> toDomainList(List<UserEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream()
                .map(UserEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
