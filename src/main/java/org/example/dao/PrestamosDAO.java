package org.example.dao;

import org.example.model.Prestamos;
import java.util.List;

public interface PrestamosDAO {

    void crear(Prestamos prestamos);

    Prestamos leer(int id);

    List<Prestamos> listar();

    void actualizar(Prestamos prestamos);

    void eliminar(int id);
}