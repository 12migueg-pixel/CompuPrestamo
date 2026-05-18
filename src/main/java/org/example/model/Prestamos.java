package org.example.model;

public class Prestamos {

    private int prestamoid;
    private int estudianteid;
    private int computadorid;
    private String fechaprestamo;
    private String fechadevolucion;
    private String responsable;
    private String estadoprestamo;

    public Prestamos() {
    }

    public Prestamos(int prestamoid, int estudianteid, int computadorid, String fechaprestamo, String fechadevolucion, String responsable, String estadoprestamo) {
        this.prestamoid = prestamoid;
        this.estudianteid = estudianteid;
        this.computadorid = computadorid;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
        this.responsable = responsable;
        this.estadoprestamo = estadoprestamo;
    }

    public int getPrestamoid() {
        return prestamoid;
    }

    public void setPrestamoid(int prestamoid) {
        this.prestamoid = prestamoid;
    }

    public int getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(int estudianteid) {
        this.estudianteid = estudianteid;
    }

    public int getComputadorid() {
        return computadorid;
    }

    public void setComputadorid(int computadorid) {
        this.computadorid = computadorid;
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstadoprestamo() {
        return estadoprestamo;
    }

    public void setEstadoprestamo(String estadoprestamo) {
        this.estadoprestamo = estadoprestamo;
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "prestamoid=" + prestamoid +
                ", estudianteid=" + estudianteid +
                ", computadorid=" + computadorid +
                ", fechaprestamo='" + fechaprestamo + '\'' +
                ", fechadevolucion='" + fechadevolucion + '\'' +
                ", responsable='" + responsable + '\'' +
                ", estadoprestamo='" + estadoprestamo + '\'' +
                '}';
    }
}
