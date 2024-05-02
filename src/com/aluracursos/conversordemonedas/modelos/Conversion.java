package com.aluracursos.conversordemonedas.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {
    private String codigoOrigen;
    private String codigoDestino;
    private double cantidad;
    private double resultado;
    private String fecha;

    public Conversion(String codigoOrigen, String codigoDestino, double cantidad, double resultado) {
        this.codigoOrigen = codigoOrigen;
        this.codigoDestino = codigoDestino;
        this.cantidad = cantidad;
        this.resultado = resultado;
        Date f = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(f);
        this.fecha = fechaFormateada;
    }

    @Override
    public String toString() {
        return "| Fecha: " + fecha + " | De: " + codigoOrigen + " | A: " + codigoDestino + " | Cantidad: " + cantidad
                + " | Resultado: " + resultado ;
    }
}
