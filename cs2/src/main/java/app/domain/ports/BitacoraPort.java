package app.domain.ports;

import java.util.List;
import java.util.Optional;
import app.domain.model.Bitacora;

public interface BitacoraPort {

    // VERIFICAR SI EXISTE
    public boolean existsById(String id);

    // BUSCAR BITÁCORA POR ID
    public Optional<Bitacora> findById(String id);

    // GUARDAR BITÁCORA
    public Bitacora save(Bitacora bitacora);

    // OBTENER TODAS LAS BITÁCORAS
    public List<Bitacora> findAll();
}