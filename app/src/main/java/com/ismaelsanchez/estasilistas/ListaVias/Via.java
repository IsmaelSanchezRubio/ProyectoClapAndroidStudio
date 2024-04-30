package com.ismaelsanchez.estasilistas.ListaVias;

public class Via {
    private String nombre;
    private int fotoVia;

    public Via() {
    }

    public Via(String nombre, int fotoVia) {
        this.nombre = nombre;
        this.fotoVia = fotoVia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFotoVia() {
        return fotoVia;
    }

    public void setFotoVia(int fotoZona) {
        this.fotoVia = fotoVia;
    }
}
