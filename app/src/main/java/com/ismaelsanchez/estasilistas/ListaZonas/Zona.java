package com.ismaelsanchez.estasilistas.ListaZonas;

public class Zona {
    private String nombre;
    private int fotoZona;

    public Zona() {
    }

    public Zona(String nombre, int fotoZona) {
        this.nombre = nombre;
        this.fotoZona = fotoZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFotoZona() {
        return fotoZona;
    }

    public void setFotoZona(int fotoZona) {
        this.fotoZona = fotoZona;
    }
}
