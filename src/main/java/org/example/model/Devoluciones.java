package org.example.model;

public class Devoluciones {

    private int devolucionid;
    private int prestamoid;
    private String fechadeentrega;
    private String estadoequipo;
    private String descripcion;

    public Devoluciones() {
    }

    public Devoluciones(int devolucionid, int prestamoid, String fechadeentrega, String estadoequipo, String descripcion) {
        this.devolucionid = devolucionid;
        this.prestamoid = prestamoid;
        this.fechadeentrega = fechadeentrega;
        this.estadoequipo = estadoequipo;
        this.descripcion = descripcion;
    }

    public int getDevolucionid() {
        return devolucionid;
    }

    public void setDevolucionid(int devolucionid) {
        this.devolucionid = devolucionid;
    }

    public int getPrestamoid() {
        return prestamoid;
    }

    public void setPrestamoid(int prestamoid) {
        this.prestamoid = prestamoid;
    }

    public String getFechadeentrega() {
        return fechadeentrega;
    }

    public void setFechadeentrega(String fechadeentrega) {
        this.fechadeentrega = fechadeentrega;
    }

    public String getEstadoequipo() {
        return estadoequipo;
    }

    public void setEstadoequipo(String estadoequipo) {
        this.estadoequipo = estadoequipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Devoluciones{" +
                "devolucionid=" + devolucionid +
                ", prestamoid=" + prestamoid +
                ", fechadeentrega='" + fechadeentrega + '\'' +
                ", estadoequipo='" + estadoequipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
