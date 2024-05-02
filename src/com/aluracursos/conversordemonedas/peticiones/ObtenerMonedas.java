package com.aluracursos.conversordemonedas.peticiones;

import com.aluracursos.conversordemonedas.modelos.Moneda;
import com.aluracursos.conversordemonedas.modelos.MonedasSoportadas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ObtenerMonedas {

    private URI direccion = URI.create("https://v6.exchangerate-api.com/v6/69e6ab8fdfa25ae1c4a264c1/codes");

    private ArrayList<Moneda> monedas = new ArrayList<Moneda>();

    public ArrayList<Moneda> obtenerMonedas() throws IOException, InterruptedException {
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
        MonedasSoportadas monedasSoportadas = gson.fromJson(json, MonedasSoportadas.class);

        for (List<String> list : monedasSoportadas.supported_codes()) {
            String codigo = list.get(0);
            String nombre = list.get(1);
            this.monedas.add(new Moneda(codigo, nombre));
        }
        return this.monedas;
    }
}
