package app.adapter.in.builders;

import java.time.LocalDateTime;

import app.domain.model.Bitacora;

public class BitacoraBuilder {

    private String logId;
    private String action;
    private String entityType;
    private String entityId;
    private String performedBy;
    private LocalDateTime timestamp;
    private String ipAddress;
    private String details;
    private boolean success;
    private String errorMessage;

    public BitacoraBuilder setLogId(String logId) {
        this.logId = logId;
        return this;
    }

    public BitacoraBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public BitacoraBuilder setEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public BitacoraBuilder setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public BitacoraBuilder setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
        return this;
    }

    public BitacoraBuilder setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BitacoraBuilder setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public BitacoraBuilder setDetails(String details) {
        this.details = details;
        return this;
    }

    public BitacoraBuilder setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public BitacoraBuilder setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Bitacora build() {
        Bitacora bitacora = new Bitacora();

        if (logId != null) bitacora.setLogId(logId);
        if (timestamp != null) bitacora.setTimestamp(timestamp);

        bitacora.setAction(action);
        bitacora.setEntityType(entityType);
        bitacora.setEntityId(entityId);
        bitacora.setPerformedBy(performedBy);
        bitacora.setIpAddress(ipAddress);
        bitacora.setDetails(details);
        bitacora.setSuccess(success);

        if (errorMessage != null) {
            bitacora.setErrorMessage(errorMessage);
        }

        return bitacora;
    }
}