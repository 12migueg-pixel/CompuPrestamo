package org.example.dao;

import org.example.model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOImpl implements EstudianteDAO {

    private final Connection connection;

    public EstudianteDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Estudiante estudiante) {

        String sql = "INSERT INTO estudiantes " +
                "(codigo_estudiantil, nombre, carrera, semestre, correo_institucional) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, estudiante.getCodigoestudiantil());
            statement.setString(2, estudiante.getNombre());
            statement.setString(3, estudiante.getCarrera());
            statement.setInt(4, estudiante.getSemestre());
            statement.setString(5, estudiante.getCorreointitucional());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante leer(int id) {

        String sql = "SELECT * FROM estudiantes WHERE estudianteid = ?";
        Estudiante estudiante = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    estudiante = new Estudiante(
                            rs.getInt("estudianteid"),
                            rs.getInt("codigo_estudiantil"),
                            rs.getString("nombre"),
                            rs.getString("carrera"),
                            rs.getInt("semestre"),
                            rs.getString("correo_institucional")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiante;
    }

    @Override
    public List<Estudiante> listar() {

        String sql = "SELECT * FROM estudiantes";
        List<Estudiante> lista = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Estudiante estudiante = new Estudiante(
                        rs.getInt("estudianteid"),
                        rs.getInt("codigo_estudiantil"),
                        rs.getString("nombre"),
                        rs.getString("carrera"),
                        rs.getInt("semestre"),
                        rs.getString("correo_institucional")
                );

                lista.add(estudiante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Estudiante estudiante) {

        String sql = "UPDATE estudiantes SET " +
                "codigo_estudiantil=?, " +
                "nombre=?, " +
                "carrera=?, " +
                "semestre=?, " +
                "correo_institucional=? " +
                "WHERE estudianteid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, estudiante.getCodigoestudiantil());
            statement.setString(2, estudiante.getNombre());
            statement.setString(3, estudiante.getCarrera());
            statement.setInt(4, estudiante.getSemestre());
            statement.setString(5, estudiante.getCorreointitucional());
            statement.setInt(6, estudiante.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM estudiantes WHERE estudianteid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}