package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = ConexionBD.obtenerConexion()) {

            EstudianteDAO estudianteDAO = new EstudianteDAOImpl(connection);
            ComputadoresDAO computadoresDAO = new ComputadoresDAOImpl(connection);
            PrestamosDAO prestamosDAO = new PrestamosDAOImpl(connection);
            DevolucionesDAO devolucionesDAO = new DevolucionesDAOImpl(connection);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {

                System.out.println("\n===== SISTEMA DE PRÉSTAMO DE COMPUTADORES =====");
                System.out.println("1. Estudiantes");
                System.out.println("2. Computadores");
                System.out.println("3. Préstamos");
                System.out.println("4. Devoluciones");
                System.out.println("5. Reportes");
                System.out.println("0. Salir");
                System.out.print("Opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: menuEstudiantes(scanner, estudianteDAO); break;
                    case 2: menuComputadores(scanner, computadoresDAO); break;
                    case 3: menuPrestamos(scanner, prestamosDAO); break;
                    case 4: menuDevoluciones(scanner, devolucionesDAO); break;
                    case 5: menuReportes(scanner, computadoresDAO, prestamosDAO); break;
                    case 0: System.out.println("Saliendo..."); break;
                    default: System.out.println("Opción inválida");
                }

            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void menuEstudiantes(Scanner scanner, EstudianteDAO estudianteDAO) {

        int op;

        do {

            System.out.println("\n--- ESTUDIANTES ---");
            System.out.println("1. Crear");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar todos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Código estudiantil: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Carrera: ");
                    String carrera = scanner.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = Integer.parseInt(scanner.nextLine());

                    System.out.print("Correo institucional: ");
                    String correo = scanner.nextLine();

                    estudianteDAO.crear(new Estudiante(0, codigo, nombre, carrera, semestre, correo));
                    System.out.println("✓ Estudiante creado exitosamente.");
                    break;

                case 2:
                    System.out.print("ID del estudiante: ");
                    int idLeer = Integer.parseInt(scanner.nextLine());
                    Estudiante encontrado = estudianteDAO.leer(idLeer);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID del estudiante a actualizar: ");
                    int idActualizar = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuevo código estudiantil: ");
                    int nuevoCodigo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Nueva carrera: ");
                    String nuevaCarrera = scanner.nextLine();

                    System.out.print("Nuevo semestre: ");
                    int nuevoSemestre = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuevo correo institucional: ");
                    String nuevoCorreo = scanner.nextLine();

                    estudianteDAO.actualizar(new Estudiante(idActualizar, nuevoCodigo, nuevoNombre, nuevaCarrera, nuevoSemestre, nuevoCorreo));
                    System.out.println("✓ Estudiante actualizado exitosamente.");
                    break;

                case 4:
                    System.out.print("ID del estudiante a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    estudianteDAO.eliminar(idEliminar);
                    System.out.println("✓ Estudiante eliminado exitosamente.");
                    break;

                case 5:
                    List<Estudiante> listaEstudiantes = estudianteDAO.listar();
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Estudiante e : listaEstudiantes) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }


    public static void menuComputadores(Scanner scanner, ComputadoresDAO computadoresDAO) {

        int op;

        do {

            System.out.println("\n--- COMPUTADORES ---");
            System.out.println("1. Crear");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar todos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Serial: ");
                    String serial = scanner.nextLine();

                    System.out.print("Estado (Disponible/Prestado/Mantenimiento): ");
                    String estado = scanner.nextLine();

                    computadoresDAO.crear(new Computadores(0, marca, modelo, serial, estado));
                    System.out.println("✓ Computador creado exitosamente.");
                    break;

                case 2:
                    System.out.print("ID del computador: ");
                    int idLeer = Integer.parseInt(scanner.nextLine());
                    Computadores encontrado = computadoresDAO.leer(idLeer);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Computador no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID del computador a actualizar: ");
                    int idActualizar = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nueva marca: ");
                    String nuevaMarca = scanner.nextLine();

                    System.out.print("Nuevo modelo: ");
                    String nuevoModelo = scanner.nextLine();

                    System.out.print("Nuevo serial: ");
                    String nuevoSerial = scanner.nextLine();

                    System.out.print("Nuevo estado: ");
                    String nuevoEstado = scanner.nextLine();

                    computadoresDAO.actualizar(new Computadores(idActualizar, nuevaMarca, nuevoModelo, nuevoSerial, nuevoEstado));
                    System.out.println("✓ Computador actualizado exitosamente.");
                    break;

                case 4:
                    System.out.print("ID del computador a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    computadoresDAO.eliminar(idEliminar);
                    System.out.println("✓ Computador eliminado exitosamente.");
                    break;

                case 5:
                    List<Computadores> listaComputadores = computadoresDAO.listar();
                    if (listaComputadores.isEmpty()) {
                        System.out.println("No hay computadores registrados.");
                    } else {
                        for (Computadores c : listaComputadores) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }


    public static void menuPrestamos(Scanner scanner, PrestamosDAO prestamosDAO) {

        int op;

        do {

            System.out.println("\n--- PRÉSTAMOS ---");
            System.out.println("1. Crear");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar todos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                case 1:
                    System.out.print("ID estudiante: ");
                    int idEstudiante = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID computador: ");
                    int idComputador = Integer.parseInt(scanner.nextLine());

                    System.out.print("Fecha préstamo (yyyy-MM-dd HH:mm:ss): ");
                    String fechaPrestamo = scanner.nextLine();

                    System.out.print("Fecha devolución (yyyy-MM-dd HH:mm:ss o enter si no aplica): ");
                    String fechaDevolucion = scanner.nextLine();
                    if (fechaDevolucion.isEmpty()) fechaDevolucion = null;

                    System.out.print("Responsable: ");
                    String responsable = scanner.nextLine();

                    System.out.print("Estado (Activo/Devuelto): ");
                    String estado = scanner.nextLine();

                    prestamosDAO.crear(new Prestamos(0, idEstudiante, idComputador, fechaPrestamo, fechaDevolucion, responsable, estado));
                    System.out.println("✓ Préstamo creado exitosamente.");
                    break;

                case 2:
                    System.out.print("ID del préstamo: ");
                    int idLeer = Integer.parseInt(scanner.nextLine());
                    Prestamos encontrado = prestamosDAO.leer(idLeer);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID del préstamo a actualizar: ");
                    int idActualizar = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID estudiante: ");
                    int nuevoEstudiante = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID computador: ");
                    int nuevoComputador = Integer.parseInt(scanner.nextLine());

                    System.out.print("Fecha préstamo (yyyy-MM-dd HH:mm:ss): ");
                    String nuevaFechaPrestamo = scanner.nextLine();

                    System.out.print("Fecha devolución (yyyy-MM-dd HH:mm:ss o enter si no aplica): ");
                    String nuevaFechaDevolucion = scanner.nextLine();
                    if (nuevaFechaDevolucion.isEmpty()) nuevaFechaDevolucion = null;

                    System.out.print("Responsable: ");
                    String nuevoResponsable = scanner.nextLine();

                    System.out.print("Estado (Activo/Devuelto): ");
                    String nuevoEstado = scanner.nextLine();

                    prestamosDAO.actualizar(new Prestamos(idActualizar, nuevoEstudiante, nuevoComputador, nuevaFechaPrestamo, nuevaFechaDevolucion, nuevoResponsable, nuevoEstado));
                    System.out.println("✓ Préstamo actualizado exitosamente.");
                    break;

                case 4:
                    System.out.print("ID del préstamo a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    prestamosDAO.eliminar(idEliminar);
                    System.out.println("✓ Préstamo eliminado exitosamente.");
                    break;

                case 5:
                    List<Prestamos> listaPrestamos = prestamosDAO.listar();
                    if (listaPrestamos.isEmpty()) {
                        System.out.println("No hay préstamos registrados.");
                    } else {
                        for (Prestamos p : listaPrestamos) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }


    public static void menuDevoluciones(Scanner scanner, DevolucionesDAO devolucionesDAO) {

        int op;

        do {

            System.out.println("\n--- DEVOLUCIONES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Listar todas");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                case 1:
                    System.out.print("ID préstamo: ");
                    int idPrestamo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Fecha de entrega (yyyy-MM-dd HH:mm:ss): ");
                    String fechaEntrega = scanner.nextLine();

                    System.out.print("Estado del equipo (Bueno/Regular/Malo): ");
                    String estadoEquipo = scanner.nextLine();

                    System.out.print("Descripción de daño (o enter si no hay): ");
                    String descripcion = scanner.nextLine();
                    if (descripcion.isEmpty()) descripcion = null;

                    devolucionesDAO.crear(new Devoluciones(0, idPrestamo, fechaEntrega, estadoEquipo, descripcion));
                    System.out.println("✓ Devolución registrada exitosamente.");
                    break;

                case 2:
                    System.out.print("ID de la devolución: ");
                    int idLeer = Integer.parseInt(scanner.nextLine());
                    Devoluciones encontrada = devolucionesDAO.leer(idLeer);
                    if (encontrada != null) {
                        System.out.println(encontrada);
                    } else {
                        System.out.println("Devolución no encontrada.");
                    }
                    break;

                case 3:
                    List<Devoluciones> listaDevoluciones = devolucionesDAO.listar();
                    if (listaDevoluciones.isEmpty()) {
                        System.out.println("No hay devoluciones registradas.");
                    } else {
                        for (Devoluciones d : listaDevoluciones) {
                            System.out.println(d);
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }


    public static void menuReportes(Scanner scanner, ComputadoresDAO computadoresDAO, PrestamosDAO prestamosDAO) {

        int op;

        do {

            System.out.println("\n--- REPORTES ---");
            System.out.println("1. Equipos disponibles");
            System.out.println("2. Historial completo de préstamos");
            System.out.println("3. Préstamos activos");
            System.out.println("4. Préstamos devueltos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                case 1:
                    System.out.println("\n=== EQUIPOS DISPONIBLES ===");
                    for (Computadores c : computadoresDAO.listar()) {
                        if (c.getEstado().equalsIgnoreCase("Disponible")) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n=== HISTORIAL COMPLETO ===");
                    for (Prestamos p : prestamosDAO.listar()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.println("\n=== PRÉSTAMOS ACTIVOS ===");
                    for (Prestamos p : prestamosDAO.listar()) {
                        if (p.getEstadoprestamo().equalsIgnoreCase("Activo")) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== PRÉSTAMOS DEVUELTOS ===");
                    for (Prestamos p : prestamosDAO.listar()) {
                        if (p.getEstadoprestamo().equalsIgnoreCase("Devuelto")) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }
}