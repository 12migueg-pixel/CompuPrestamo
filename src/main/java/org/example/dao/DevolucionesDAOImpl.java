package org.example.dao;

import org.example.model.Devoluciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevolucionesDAOImpl implements DevolucionesDAO {

    private final Connection connection;

    public DevolucionesDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Devoluciones devoluciones) {

        String sql = "INSERT INTO devoluciones " +
                "(prestamoid, fecha_entrega, estado_equipo, descripcion_dano) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, devoluciones.getPrestamoid());
            statement.setString(2, devoluciones.getFechadeentrega());
            statement.setString(3, devoluciones.getEstadoequipo());
            statement.setString(4, devoluciones.getDescripcion());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Devoluciones leer(int id) {

        String sql = "SELECT * FROM devoluciones WHERE devolucionid = ?";
        Devoluciones devoluciones = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    devoluciones = new Devoluciones(
                            rs.getInt("devolucionid"),
                            rs.getInt("prestamoid"),
                            rs.getString("fecha_entrega"),
                            rs.getString("estado_equipo"),
                            rs.getString("descripcion_dano")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return devoluciones;
    }

    @Override
    public List<Devoluciones> listar() {

        String sql = "SELECT * FROM devoluciones";
        List<Devoluciones> lista = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Devoluciones devoluciones = new Devoluciones(
                        rs.getInt("devolucionid"),
                        rs.getInt("prestamoid"),
                        rs.getString("fecha_entrega"),
                        rs.getString("estado_equipo"),
                        rs.getString("descripcion_dano")
                );

                lista.add(devoluciones);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Devoluciones devoluciones) {

        String sql = "UPDATE devoluciones SET " +
                "prestamoid=?, " +
                "fecha_entrega=?, " +
                "estado_equipo=?, " +
                "descripcion_dano=? " +
                "WHERE devolucionid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, devoluciones.getPrestamoid());
            statement.setString(2, devoluciones.getFechadeentrega());
            statement.setString(3, devoluciones.getEstadoequipo());
            statement.setString(4, devoluciones.getDescripcion());
            statement.setInt(5, devoluciones.getDevolucionid());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM devoluciones WHERE devolucionid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}