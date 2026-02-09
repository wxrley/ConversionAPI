package com.wxrley.conversionapi.service;

import com.wxrley.conversionapi.dto.ConversionDTO;
import com.wxrley.conversionapi.exception.ConversionRateNotFoundException;
import com.wxrley.conversionapi.validator.ConversionValidator;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Contém a lógica de negócio da aplicação.
 * Chamados pelo Controller para processar operações.
 */
@Service
public class CurrencyConversionService {

    private static final Map<String, Double> RATES = Map.of(
            "USD-BRL", 5.20,
            "BRL-USD", 0.19,
            "USD-EUR", 0.90,
            "EUR-USD", 1.11,
            "BRL-EUR", 0.17,
            "EUR-BRL", 5.85
    );

    /**
     * Converte valor entre moedas usando taxas pré-definidas.
     * Valida moedas e valor através do ConversionValidator.
     * Lança ConversionRateNotFoundException se par de moedas não existe.
     */
    public ConversionDTO convert(String from, String to, double amount) {
        ConversionValidator.validate("currency", from, to, amount);

        String key = from.toUpperCase() + "-" + to.toUpperCase();
        Double rate = RATES.get(key);

        if (rate == null) {
            throw new ConversionRateNotFoundException("Taxa de conversão não encontrada para " + key);
        }

        double convertedValue = amount * rate;

        return new ConversionDTO(from.toUpperCase(), to.toUpperCase(), amount, convertedValue, "currency");
    }
}