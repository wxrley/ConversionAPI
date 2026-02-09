package com.wxrley.conversionapi.exception;

/**
 * Exceção lançada quando taxa de conversão não é encontrada.
 * Usada por CurrencyConversionService quando par de moedas não existe.
 */
public class ConversionRateNotFoundException extends RuntimeException {
    public ConversionRateNotFoundException(String message) {
        super(message);
    }
}