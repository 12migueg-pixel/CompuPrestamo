package org.example.dao;

import org.example.model.Devoluciones;
import java.util.List;

public interface DevolucionesDAO {

    void crear(Devoluciones devoluciones);

    Devoluciones leer(int id);

    List<Devoluciones> listar();

    void actualizar(Devoluciones devoluciones);

    void eliminar(int id);

}