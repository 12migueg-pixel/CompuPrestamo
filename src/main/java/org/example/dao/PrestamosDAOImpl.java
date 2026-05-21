package org.example.dao;

import org.example.model.Prestamos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAOImpl implements PrestamosDAO {

    private final Connection connection;

    public PrestamosDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Prestamos prestamos) {

        String sql = "INSERT INTO prestamos " +
                "(estudianteid, computadorid, fecha_prestamo, fecha_devolucion, responsable, estado_prestamo) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, prestamos.getEstudianteid());
            statement.setInt(2, prestamos.getComputadorid());
            statement.setString(3, prestamos.getFechaprestamo());
            statement.setString(4, prestamos.getFechadevolucion());
            statement.setString(5, prestamos.getResponsable());
            statement.setString(6, prestamos.getEstadoprestamo());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Prestamos leer(int id) {

        String sql = "SELECT * FROM prestamos WHERE prestamoid = ?";
        Prestamos prestamos = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    prestamos = new Prestamos(
                            rs.getInt("prestamoid"),
                            rs.getInt("estudianteid"),
                            rs.getInt("computadorid"),
                            rs.getString("fecha_prestamo"),
                            rs.getString("fecha_devolucion"),
                            rs.getString("responsable"),
                            rs.getString("estado_prestamo")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;
    }

    @Override
    public List<Prestamos> listar() {

        String sql = "SELECT * FROM prestamos";
        List<Prestamos> lista = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Prestamos prestamos = new Prestamos(
                        rs.getInt("prestamoid"),
                        rs.getInt("estudianteid"),
                        rs.getInt("computadorid"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_devolucion"),
                        rs.getString("responsable"),
                        rs.getString("estado_prestamo")
                );

                lista.add(prestamos);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Prestamos prestamos) {

        String sql = "UPDATE prestamos SET " +
                "estudianteid=?, " +
                "computadorid=?, " +
                "fecha_prestamo=?, " +
                "fecha_devolucion=?, " +
                "responsable=?, " +
                "estado_prestamo=? " +
                "WHERE prestamoid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, prestamos.getEstudianteid());
            statement.setInt(2, prestamos.getComputadorid());
            statement.setString(3, prestamos.getFechaprestamo());
            statement.setString(4, prestamos.getFechadevolucion());
            statement.setString(5, prestamos.getResponsable());
            statement.setString(6, prestamos.getEstadoprestamo());
            statement.setInt(7, prestamos.getPrestamoid());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM prestamos WHERE prestamoid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}