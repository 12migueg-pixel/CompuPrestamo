package org.example.dao;

import org.example.model.Computadores;

import java.util.List;

public interface ComputadoresDAO {

    void crear(Computadores computadores);

    Computadores leer(int id);

    List<Computadores> listar();

    void actualizar(Computadores computadores);

    void eliminar(int id);

}