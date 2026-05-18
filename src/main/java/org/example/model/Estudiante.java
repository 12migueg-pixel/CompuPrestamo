package org.example.model;

public class Estudiante {

    private int id;
    private int codigoestudiantil;
    private String nombre;
    private String carrera;
    private int semestre;
    private  String correointitucional;

    public Estudiante() {
    }

    public Estudiante(int id, int codigoestudiantil, String nombre, String carrera, int semestre, String correointitucional) {
        this.id = id;
        this.codigoestudiantil = codigoestudiantil;
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.correointitucional = correointitucional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoestudiantil() {
        return codigoestudiantil;
    }

    public void setCodigoestudiantil(int codigoestudiantil) {
        this.codigoestudiantil = codigoestudiantil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCorreointitucional() {
        return correointitucional;
    }

    public void setCorreointitucional(String correointitucional) {
        this.correointitucional = correointitucional;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", codigoestudiantil=" + codigoestudiantil +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", correointitucional='" + correointitucional + '\'' +
                '}';
    }


    public int getEstudianteid() {
        return 0;
    }
}
