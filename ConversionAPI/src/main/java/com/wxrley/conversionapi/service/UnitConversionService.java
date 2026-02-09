package com.wxrley.conversionapi.service;

import com.wxrley.conversionapi.dto.ConversionDTO;
import com.wxrley.conversionapi.exception.UnsupportedUnitException;
import com.wxrley.conversionapi.validator.ConversionValidator;
import org.springframework.stereotype.Service;

/**
 * Contém a lógica de negócio da aplicação.
 * Chamados pelo Controller para processar operações.
 */
@Service
public class UnitConversionService {

    /**
     * Converte temperatura entre Celsius e Fahrenheit.
     * Valida unidades e valor através do ConversionValidator.
     */
    public ConversionDTO temperatureConverter(String from, String to, double value) {
        ConversionValidator.validate("temperature", from, to, value);

        if (from.equalsIgnoreCase(to)) {
            return new ConversionDTO(from.toUpperCase(), to.toUpperCase(), value, value, "temperature");
        }

        double convertedValue;

        if (from.equalsIgnoreCase("C") && to.equalsIgnoreCase("F")) {
            convertedValue = (value * 9 / 5) + 32;
        } else if (from.equalsIgnoreCase("F") && to.equalsIgnoreCase("C")) {
            convertedValue = (value - 32) * 5 / 9;
        } else {
            throw new UnsupportedUnitException("Conversão de temperatura inválida");
        }

        return new ConversionDTO(from.toUpperCase(), to.toUpperCase(), value, convertedValue, "temperature");
    }

    /**
     * Converte distância entre quilômetros e milhas.
     * Valida unidades e valor através do ConversionValidator.
     */
    public ConversionDTO convertDistance(String from, String to, double value) {
        ConversionValidator.validate("distance", from, to, value);

        if (from.equalsIgnoreCase(to)) {
            return new ConversionDTO(from.toUpperCase(), to.toUpperCase(), value, value, "distance");
        }

        double convertedValue;

        if (from.equalsIgnoreCase("KM") && to.equalsIgnoreCase("MI")) {
            convertedValue = value * 0.621371;
        } else if (from.equalsIgnoreCase("MI") && to.equalsIgnoreCase("KM")) {
            convertedValue = value / 0.621371;
        } else {
            throw new UnsupportedUnitException("Conversão de distância inválida");
        }

        return new ConversionDTO(from.toUpperCase(), to.toUpperCase(), value, convertedValue, "distance");
    }
}