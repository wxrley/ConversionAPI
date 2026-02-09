package com.wxrley.conversionapi.validator;

import com.wxrley.conversionapi.exception.NegativeAmountNotAllowedException;
import com.wxrley.conversionapi.exception.UnsupportedUnitException;

import java.util.List;
import java.util.Map;

/**
 * Valida dados de conversão antes do processamento.
 * Verifica unidades suportadas e valores permitidos por tipo de conversão.
 */
public class ConversionValidator {

    private static final Map<String, List<String>> SUPPORTED_TYPES = Map.of(
            "currency", List.of("USD", "BRL", "EUR"),
            "temperature", List.of("C", "F"),
            "distance", List.of("KM", "MI")
    );

    /**
     * Valida tipo de conversão, unidades e valor.
     * Permite valores negativos apenas para temperatura.
     * Lança NegativeAmountNotAllowedException ou UnsupportedUnitException se inválido.
     */
    public static void validate(String type, String from, String to, double value) {
        if (!type.equals("temperature") && value < 0) {
            throw new NegativeAmountNotAllowedException("Valor negativo não permitido");
        }

        List<String> supportedUnits = SUPPORTED_TYPES.get(type);

        if (supportedUnits == null) {
            throw new UnsupportedUnitException("Tipo de conversão inválido: " + type);
        }

        if (!supportedUnits.contains(from.toUpperCase())) {
            throw new UnsupportedUnitException("Unidade de origem não suportada: " + from);
        }

        if (!supportedUnits.contains(to.toUpperCase())) {
            throw new UnsupportedUnitException("Unidade de destino não suportada: " + to);
        }
    }
}