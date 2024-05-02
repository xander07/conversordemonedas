package com.aluracursos.conversordemonedas.modelos;

public record ConversionGson(String base_code,
                             String target_code,
                             double conversion_result) {
}
