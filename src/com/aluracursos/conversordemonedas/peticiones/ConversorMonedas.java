package com.aluracursos.conversordemonedas.peticiones;

import com.aluracursos.conversordemonedas.modelos.Conversion;
import com.aluracursos.conversordemonedas.modelos.Moneda;
import com.aluracursos.conversordemonedas.modelos.MonedasSoportadas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConversorMonedas {
    private String codigoOrigen;
    private String codigoDestino;
    private double cantidad;
    private URI direccion;
    private double conversion;

    public ConversorMonedas(String codigoOrigen, String codigoDestino, double cantidad) {
        this.codigoOrigen = codigoOrigen;
        this.codigoDestino = codigoDestino;
        this.cantidad = cantidad;
        this.direccion = URI.create("https://v6.exchangerate-api.com/v6/69e6ab8fdfa25ae1c4a264c1/pair/" +
                codigoOrigen + "/" + codigoDestino + "/" + cantidad);
    }

    public double convertirMonedas() throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(this.direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Conversion conversion1 = gson.fromJson(json, Conversion.class);

        this.conversion = conversion1.conversion_result();

        return this.conversion;
    }

}
