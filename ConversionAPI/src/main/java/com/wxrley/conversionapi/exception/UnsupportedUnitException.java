package com.wxrley.conversionapi.exception;

/**
 * Exceção lançada quando unidade de conversão não é suportada.
 * Usada por ConversionValidator e UnitConversionService.
 */
public class UnsupportedUnitException extends RuntimeException {
    public UnsupportedUnitException(String message) {
        super(message);
    }
}