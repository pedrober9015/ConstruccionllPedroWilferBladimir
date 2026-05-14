package app.infrastructure.Persistence.mapper;

import app.domain.model.Product;
import app.infrastructure.Persistence.entities.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de infraestructura entre {@link Product} y {@link ProductEntity}.
 */
public class ProductEntityMapper {

    /**
     * Convierte una entidad JPA a objeto de dominio.
     *
     * @param entity entidad JPA; si es null retorna null
     * @return objeto de dominio completamente poblado
     */
    public static Product toDomain(ProductEntity entity) {
        if (entity == null) return null;

        Product domain = new Product();
        domain.setProductId(entity.getProductId());
        domain.setName(entity.getName());
        domain.setDescription(entity.getDescription());
        domain.setProductType(entity.getProductType());
        domain.setBaseInterestRate(entity.getBaseInterestRate());
        domain.setMinimumAmount(entity.getMinimumAmount());
        domain.setMaximumAmount(entity.getMaximumAmount());
        domain.setAvailable(entity.isAvailable());
        domain.setLaunchDate(entity.getLaunchDate());
        domain.setTermsAndConditions(entity.getTermsAndConditions());

        return domain;
    }

    /**
     * Convierte un objeto de dominio a entidad JPA.
     *
     * @param domain objeto de dominio; si es null retorna null
     * @return entidad JPA lista para persistir
     */
    public static ProductEntity toEntity(Product domain) {
        if (domain == null) return null;

        ProductEntity entity = new ProductEntity();
        entity.setProductId(domain.getProductId());
        entity.setName(domain.getName());
        entity.setDescription(domain.getDescription());
        entity.setProductType(domain.getProductType());
        entity.setBaseInterestRate(domain.getBaseInterestRate());
        entity.setMinimumAmount(domain.getMinimumAmount());
        entity.setMaximumAmount(domain.getMaximumAmount());
        entity.setAvailable(domain.isAvailable());
        entity.setLaunchDate(domain.getLaunchDate());
        entity.setTermsAndConditions(domain.getTermsAndConditions());

        return entity;
    }

    /**
     * Actualiza una entidad JPA existente con los datos del objeto de dominio.
     *
     * @param domain objeto de dominio con los nuevos valores
     * @param entity entidad JPA a actualizar in-place
     */
    public static void updateEntity(Product domain, ProductEntity entity) {
        if (domain == null || entity == null) return;

        entity.setName(domain.getName());
        entity.setDescription(domain.getDescription());
        entity.setProductType(domain.getProductType());
        entity.setBaseInterestRate(domain.getBaseInterestRate());
        entity.setMinimumAmount(domain.getMinimumAmount());
        entity.setMaximumAmount(domain.getMaximumAmount());
        entity.setAvailable(domain.isAvailable());
        entity.setLaunchDate(domain.getLaunchDate());
        entity.setTermsAndConditions(domain.getTermsAndConditions());
    }

    /**
     * Convierte una lista de entidades JPA a lista de objetos de dominio.
     *
     * @param entities lista de entidades; nunca retorna null
     * @return lista de objetos de dominio
     */
    public static List<Product> toDomainList(List<ProductEntity> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream()
                .map(ProductEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
