package app.domain.ports;

import app.domain.model.Bitacora;

public interface BitacoraPort {
    public boolean existsById(String id);
    public Bitacora findById(String id);
    public void save(Bitacora bitacora);
}