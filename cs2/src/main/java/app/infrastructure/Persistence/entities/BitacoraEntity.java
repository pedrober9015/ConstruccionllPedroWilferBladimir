package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bitacora")
public class BitacoraEntity {

    // ID DEL LOG
    @Id
    @Column(name = "log_id", length = 36)
    private String logId;

    // ACCION REALIZADA
    @Column(name = "action", nullable = false, length = 100)
    private String action;

    // TIPO DE ENTIDAD AFECTADA
    @Column(name = "entity_type", length = 50)
    private String entityType;

    // ID DE LA ENTIDAD AFECTADA
    @Column(name = "entity_id", length = 100)
    private String entityId;

    // USUARIO QUE REALIZO LA ACCION
    @Column(name = "performed_by", length = 100)
    private String performedBy;

    // FECHA Y HORA DEL EVENTO
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    // DIRECCION IP
    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    // DETALLES DEL EVENTO
    @Column(name = "details", length = 1000)
    private String details;

    // SI LA OPERACION FUE EXITOSA
    @Column(name = "success", nullable = false)
    private boolean success;

    // MENSAJE DE ERROR
    @Column(name = "error_message", length = 500)
    private String errorMessage;

    public BitacoraEntity() {
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}