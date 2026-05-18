package org.example.dao;

import org.example.model.Computadores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComputadoresDAOImpl implements ComputadoresDAO {

    private final Connection connection;

    public ComputadoresDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Computadores computadores) {

        String sql = "INSERT INTO computadores " +
                "(computadorid, marca, modelo, serial, estado) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, computadores.getComputadorid());
            statement.setString(2, computadores.getMarca());
            statement.setString(3, computadores.getModelo());
            statement.setString(4, computadores.getSerial());
            statement.setString(5, computadores.getEstado());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Computadores leer(int id) {

        String sql = "SELECT * FROM computadores WHERE computadorid = ?";
        Computadores computadores = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                computadores = new Computadores(
                        rs.getInt("computadorid"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("serial"),
                        rs.getString("estado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return computadores;
    }

    @Override
    public List<Computadores> listar() {

        String sql = "SELECT * FROM computadores";
        List<Computadores> lista = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Computadores computadores = new Computadores(
                        rs.getInt("computadorid"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("serial"),
                        rs.getString("estado")
                );

                lista.add(computadores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Computadores computadores) {

        String sql = "UPDATE computadores SET " +
                "marca=?, " +
                "modelo=?, " +
                "serial=?, " +
                "estado=? " +
                "WHERE computadorid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, computadores.getMarca());
            statement.setString(2, computadores.getModelo());
            statement.setString(3, computadores.getSerial());
            statement.setString(4, computadores.getEstado());
            statement.setInt(5, computadores.getComputadorid());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM computadores WHERE computadorid=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}