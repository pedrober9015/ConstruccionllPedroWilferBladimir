package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.infrastructure.persistence.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserEntityMapper {

    /**
     * Convierte UserEntity -> User
     */
    public static User toDomain(UserEntity entity) {

        if (entity == null) {
            return null;
        }

        return new User(
                entity.getIdUser(),
                entity.getIdRelation(),
                entity.getFullName(),
                entity.getIdentification(),
                entity.getEmail(),
                entity.getTelephone(),
                entity.getDateBirth(),
                entity.getDirection(),
                entity.getRoleSystem(),
                entity.getEstatUser(),
                entity.getPassword()
        );
    }

    /**
     * Convierte User -> UserEntity
     */
    public static UserEntity toEntity(User domain) {

        if (domain == null) {
            return null;
        }

        UserEntity entity = new UserEntity();

        entity.setIdUser(domain.getIduser());
        entity.setIdRelation(domain.getIdrelation());
        entity.setFullName(domain.getFullname());
        entity.setIdentification(domain.getIdidenfication());
        entity.setEmail(domain.getEmail());
        entity.setTelephone(domain.getTelephone());
        entity.setDateBirth(domain.getDatebirth());
        entity.setDirection(domain.getDirection());
        entity.setRoleSystem(domain.getRolesystem());
        entity.setEstatUser(domain.getEstatUser());
        entity.setPassword(domain.getPassword());

        return entity;
    }

    /**
     * Actualiza una entidad existente
     */
    public static void updateEntity(User domain, UserEntity entity) {

        if (domain == null || entity == null) {
            return;
        }

        entity.setIdRelation(domain.getIdrelation());
        entity.setFullName(domain.getFullname());
        entity.setIdentification(domain.getIdidenfication());
        entity.setEmail(domain.getEmail());
        entity.setTelephone(domain.getTelephone());
        entity.setDateBirth(domain.getDatebirth());
        entity.setDirection(domain.getDirection());
        entity.setRoleSystem(domain.getRolesystem());
        entity.setEstatUser(domain.getEstatUser());

        // Actualiza password solo si viene informado
        if (domain.getPassword() != null
                && !domain.getPassword().isBlank()) {

            entity.setPassword(domain.getPassword());
        }
    }

    /**
     * Convierte lista de entidades a dominio
     */
    public static List<User> toDomainList(List<UserEntity> entities) {

        if (entities == null) {
            return new ArrayList<>();
        }

        return entities.stream()
                .map(UserEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}