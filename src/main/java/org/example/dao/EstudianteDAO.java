package org.example.dao;

import org.example.model.Estudiante;

import java.util.List;

public interface EstudianteDAO {

    void crear(Estudiante estudiante);

    Estudiante leer(int id);

    List<Estudiante> listar();

    void actualizar(Estudiante estudiante);

    void eliminar(int id);

}