package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = ConexionBD.obtenerConexion()) {

            EstudianteDAOImpl estudianteDAO = new EstudianteDAOImpl(connection);
            ComputadoresDAOImpl computadoresDAO = new ComputadoresDAOImpl(connection);
            PrestamosDAOImpl prestamosDAO = new PrestamosDAOImpl(connection);
            DevolucionesDAOImpl devolucionesDAO = new DevolucionesDAOImpl(connection);

            // ===================== ESTUDIANTES =====================
            // Ya existen 5 en Docker, agregamos 5 más
            estudianteDAO.crear(new Estudiante(0, 20241006, "Valentina Cruz", "Ingenieria de Sistemas", 3, "vcruz@ucundinamarca.edu.co"));
            estudianteDAO.crear(new Estudiante(0, 20241007, "Andres Mora", "Ingenieria Industrial", 2, "amora@ucundinamarca.edu.co"));
            estudianteDAO.crear(new Estudiante(0, 20241008, "Camila Perez", "Contaduria Publica", 4, "cperez@ucundinamarca.edu.co"));
            estudianteDAO.crear(new Estudiante(0, 20241009, "Julian Ramirez", "Administracion de Empresas", 1, "jramirez@ucundinamarca.edu.co"));
            estudianteDAO.crear(new Estudiante(0, 20241010, "Natalia Gomez", "Ingenieria Electronica", 5, "ngomez@ucundinamarca.edu.co"));

            System.out.println("=== ESTUDIANTES ===");
            for (Estudiante e : estudianteDAO.listar()) {
                System.out.println(e);
            }

            // ===================== PRESTAMOS =====================
            // Ya existen 4 en Docker, agregamos 5 más
            prestamosDAO.crear(new Prestamos(0, 1, 3, "2026-05-14 09:00:00", null, "Pedro Lopez", "Activo"));
            prestamosDAO.crear(new Prestamos(0, 2, 4, "2026-05-15 10:30:00", "2026-05-16 12:00:00", "Ana Ruiz", "Devuelto"));
            prestamosDAO.crear(new Prestamos(0, 3, 1, "2026-05-16 08:00:00", null, "Carlos Vega", "Activo"));
            prestamosDAO.crear(new Prestamos(0, 4, 5, "2026-05-17 11:00:00", "2026-05-18 09:00:00", "Maria Torres", "Devuelto"));
            prestamosDAO.crear(new Prestamos(0, 5, 2, "2026-05-18 14:00:00", null, "Juan Mesa", "Activo"));

            System.out.println("\n=== PRESTAMOS ===");
            for (Prestamos p : prestamosDAO.listar()) {
                System.out.println(p);
            }

            // ===================== DEVOLUCIONES =====================
            // Agregamos 5 devoluciones
            devolucionesDAO.crear(new Devoluciones(0, 1, "2026-05-12 10:00:00", "Bueno", "Sin daños"));
            devolucionesDAO.crear(new Devoluciones(0, 3, "2026-05-11 18:00:00", "Regular", "Pantalla rayada"));
            devolucionesDAO.crear(new Devoluciones(0, 6, "2026-05-16 12:00:00", "Bueno", "Sin daños"));
            devolucionesDAO.crear(new Devoluciones(0, 8, "2026-05-18 09:00:00", "Malo", "Teclado dañado"));
            devolucionesDAO.crear(new Devoluciones(0, 9, "2026-05-19 16:00:00", "Bueno", "Sin daños"));

            System.out.println("\n=== DEVOLUCIONES ===");
            for (Devoluciones d : devolucionesDAO.listar()) {
                System.out.println(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}