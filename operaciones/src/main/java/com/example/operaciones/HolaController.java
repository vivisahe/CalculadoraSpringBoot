package com.example.operaciones;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HolaController {
    @PostMapping(
            path = "/calcular",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> calcular(@RequestBody Map<String, String> datos) {
        double num1 = Double.parseDouble(datos.get("numero1"));
        double num2 = Double.parseDouble(datos.get("numero2"));
        String operacion = datos.get("operacion");

        double resultado;
        switch (operacion) {
            case "sumar":
                resultado = num1 + num2;
                break;
            case "restar":
                resultado = num1 - num2;
                break;
            case "multiplicar":
                resultado = num1 * num2;
                break;
            case "dividir":
                if (num2 == 0) {
                    return Map.of("resultado", "Error: división por cero");
                }
                resultado = num1 / num2;
                break;
            default:
                return Map.of("resultado", "Operación no válida");
        }

        return Map.of("resultado", String.valueOf(resultado));
    }

}
