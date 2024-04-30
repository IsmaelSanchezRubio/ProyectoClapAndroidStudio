package com.ismaelsanchez.estasilistas.Extra;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClaseGlobal extends Application {
    private String zona;
    private String via;
    private String nombre;
    private String ipObtenida;
    private String passwordObtenida;
    private String portObtenida;

    public String getPortObtenida() {
        return portObtenida;
    }
    public void setPortObtenida(String portObtenida) {
        this.portObtenida = portObtenida;
    }


    public String getPasswordObtenida() {
        return passwordObtenida;
    }
    public void setPasswordObtenida(String passwordObtenida) {
        this.passwordObtenida = passwordObtenida;
    }


    public String getIpObtenida() {
        return ipObtenida;
    }
    public void setIpObtenida(String ipObtenida) {
        this.ipObtenida = ipObtenida;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }


}
