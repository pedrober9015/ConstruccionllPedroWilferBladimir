package app.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bitacora {

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

    public Bitacora() {
        this.logId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    public Bitacora(String action, String entityType, String entityId,
                    String performedBy, String ipAddress, String details, boolean success) {
        this();
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.performedBy = performedBy;
        this.ipAddress = ipAddress;
        this.details = details;
        this.success = success;
    }

    public static Bitacora success(String action, String entityType, String entityId,
                                   String performedBy, String ipAddress, String details) {
        return new Bitacora(action, entityType, entityId, performedBy, ipAddress, details, true);
    }

    public static Bitacora failure(String action, String entityType, String entityId,
                                   String performedBy, String ipAddress, String errorMessage) {
        Bitacora log = new Bitacora(action, entityType, entityId, performedBy, ipAddress, null, false);
        log.setErrorMessage(errorMessage);
        return log;
    }

    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }

    public String getPerformedBy() { return performedBy; }
    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    @Override
    public String toString() {
        return "Bitacora{logId='" + logId + "', action='" + action
                + "', entity=" + entityType + "[" + entityId + "]"
                + ", performedBy='" + performedBy + "', timestamp=" + timestamp
                + ", success=" + success + "}";
    }
}
