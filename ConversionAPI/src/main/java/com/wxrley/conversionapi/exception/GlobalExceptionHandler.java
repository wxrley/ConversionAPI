package com.wxrley.conversionapi.exception;

import com.wxrley.conversionapi.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Captura e trata exceções globalmente na aplicação.
 * Retorna ErrorDTO padronizado para as 3 exceções customizadas.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConversionRateNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleConversionRateNotFound(ConversionRateNotFoundException ex) {
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NegativeAmountNotAllowedException.class)
    public ResponseEntity<ErrorDTO> handleNegativeAmount(NegativeAmountNotAllowedException ex) {
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(UnsupportedUnitException.class)
    public ResponseEntity<ErrorDTO> handleUnsupportedUnit(UnsupportedUnitException ex) {
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(error);
    }
}