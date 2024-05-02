package com.aluracursos.conversordemonedas.modelos;

import java.util.List;

public record MonedasSoportadas(
        List<List<String>> supported_codes
) {
}
