package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.Moneda;
import com.aluracursos.conversordemonedas.peticiones.ObtenerMonedas;

import java.io.IOException;

public class Menu {

    public static final String MENSAJE_BIENVENIDA = "Bienvenido al Convertidor de Monedas :) \n" +
            "Escoge la moneda que quieres convertir: \n";;

    public static final String MENSAJE_MONEDA_DESTINO = "Ahora escoge la moneda a la que deseas convertir: \n";

    public static final String MENSAJE_CANTIDAD_A_CONVERTIR = "Ingrese la cantidad que deseas convertir: \n";

    public String menuMonedas = "0) Salir \n";

    public Menu(ObtenerMonedas monedas) {
        int contador = 1;

        try {
            for(Moneda moneda : monedas.obtenerMonedas()) {
                menuMonedas += contador + ") " + moneda.getNombre() + "\n";
                contador++;
            }
        } catch (IOException |InterruptedException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
}
