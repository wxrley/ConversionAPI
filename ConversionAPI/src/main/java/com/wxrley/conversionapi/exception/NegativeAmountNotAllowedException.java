package com.wxrley.conversionapi.exception;

/**
 * Exceção lançada quando valor negativo não é permitido.
 * Usada por ConversionValidator em conversões de moeda e distância.
 */
public class NegativeAmountNotAllowedException extends RuntimeException {
    public NegativeAmountNotAllowedException(String message) {
        super(message);
    }
}