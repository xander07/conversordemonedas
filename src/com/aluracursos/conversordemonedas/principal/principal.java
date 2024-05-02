package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.peticiones.ConversorMonedas;
import com.aluracursos.conversordemonedas.peticiones.ObtenerMonedas;
import java.util.List;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {

    static Scanner scanner = new Scanner(System.in);

    static int opcionOrigen;
    static String codOrigen;
    static int opcionDestino;
    static String codDestino;
    static int opcion;
    static double cantidad;
    static double resultado;


    static ObtenerMonedas monedas = new ObtenerMonedas();
    static Menu menu;


    public static void main(String[] args) {

        menu();

    }

    public static void menu(){


        try {
            menu = new Menu(monedas);
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }

        while(true){
            System.out.println("*******************************************");
            System.out.println(menu.MENSAJE_BIENVENIDA);
            int startIndex = 0;
            int endIndex = 10;
            boolean mostrarMas = true;
            List<String> opciones = menu.opciones;

            while (mostrarMas){
                System.out.println("*******************************************");
                System.out.println("0) Salir \n");
                for (int i = startIndex; i < endIndex && i < opciones.size() ; i++) {
                    System.out.println((i+1) + ") " + opciones.get(i));
                }

                System.out.println("*******************************************");
                System.out.println("¿Desea ver más opciones? \n" +
                        "0) Atrás \n1) Si \n2) No \n");

                int respuesta = scanner.nextInt();
                if (respuesta == 0){
                    endIndex = startIndex;
                    startIndex -= 10;
                    if (startIndex < 0){
                        startIndex = 0;
                        endIndex = 10;
                    }
                } else if (respuesta == 1){
                    startIndex = endIndex;
                    endIndex += 10;
                } else if (respuesta == 2){
                    mostrarMas = false;
                }

            }

            try {
                System.out.println("Ingrese la moneda a convertir: \n");
                opcionOrigen = scanner.nextInt();
                if (opcionOrigen == 0){
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    break;
                }
                codOrigen = monedas.obtenerMonedas().get(opcionOrigen - 1).getCodigo();

                System.out.println(menu.MENSAJE_MONEDA_DESTINO);

                startIndex = 0;
                endIndex = 10;
                mostrarMas = true;

                while (mostrarMas){
                    System.out.println("*******************************************");
                    System.out.println("0) Salir \n");
                    for (int i = startIndex; i < endIndex && i < opciones.size() ; i++) {
                        System.out.println((i+1) + ") " + opciones.get(i));
                    }

                    System.out.println("*******************************************");
                    System.out.println("¿Desea ver más opciones? \n" +
                            "0) Atrás \n1) Si \n2) No \n");

                    int respuesta = scanner.nextInt();
                    if (respuesta == 0){
                        endIndex = startIndex;
                        startIndex -= 10;
                        if (startIndex < 0){
                            startIndex = 0;
                            endIndex = 10;
                        }
                    } else if (respuesta == 1){
                        startIndex = endIndex;
                        endIndex += 10;
                    } else if (respuesta == 2){
                        mostrarMas = false;
                    }

                }

                System.out.println("Ingrese la moneda destino: \n");
                opcionDestino = scanner.nextInt();
                if (opcionDestino == 0){
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    break;
                }
                codDestino = monedas.obtenerMonedas().get(opcionDestino - 1).getCodigo();

                System.out.println(menu.MENSAJE_CANTIDAD_A_CONVERTIR);
                cantidad = scanner.nextDouble();

                ConversorMonedas convertir = new ConversorMonedas(codOrigen, codDestino, cantidad);
                resultado = convertir.convertirMonedas();

                System.out.println("El valor de " + cantidad + " [" + codOrigen + "] " +
                        "corresponde a =>>> " + resultado + " [" + codDestino + "] ");
                System.out.println("***********************************************");
                System.out.println("¿Deseas realizar otra conversión ? \n" +
                        "1. Si \n" + "2. No \n");

                opcion = scanner.nextInt();

                if (opcion == 2){
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    break;
                }
            } catch (NumberFormatException | InputMismatchException | IndexOutOfBoundsException e){
                System.out.println("Error: Debe ingresar el número de la opción correcta");
                break;
            } catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
                break;
            }
        }
    }
}
