package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;

public class Moneda {

    private String codigo;
    private String nombre;
    private ArrayList<Moneda> historialConversiones =  new ArrayList();

    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarHistorial(Moneda moneda) {
        historialConversiones.add(moneda);
    }

    public ArrayList<Moneda> getHistorialConversiones() {
        return historialConversiones;
    }

    @Override
    public String toString() {
        return "{" +
                "codigo: " + codigo +
                ", nombre: " + nombre +
                "}";
    }
}
