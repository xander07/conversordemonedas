package com.aluracursos.conversordemonedas.modelos;

public record Conversion(String base_code,
                         String target_code,
                         double conversion_result) {
}
