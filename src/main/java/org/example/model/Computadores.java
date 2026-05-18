package org.example.model;

public class Computadores {

    private int computadorid;
    private String marca;
    private String modelo;
    private String serial;
    private String estado;

    public Computadores() {
    }

    public Computadores(int computadorid, String marca, String modelo, String serial, String estado) {
        this.computadorid = computadorid;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.estado = estado;
    }

    public int getComputadorid() {
        return computadorid;
    }

    public void setComputadorid(int computadorid) {
        this.computadorid = computadorid;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Computadores{" +
                "computadorid=" + computadorid +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", serial='" + serial + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
