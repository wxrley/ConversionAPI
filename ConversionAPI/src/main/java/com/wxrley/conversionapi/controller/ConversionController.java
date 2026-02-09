package com.wxrley.conversionapi.controller;

import com.wxrley.conversionapi.dto.ConversionDTO;
import com.wxrley.conversionapi.service.CurrencyConversionService;
import com.wxrley.conversionapi.service.UnitConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Recebe requisições HTTP da API.
 * Delega processamento aos Services e retorna respostas.
 * Swagger UI: http://localhost:8080/swagger-ui/index.html
 */
@Tag(name = "Conversion API", description = "Endpoints para conversão de moedas, temperatura e distância")
@RestController
@RequestMapping("/convert")
public class ConversionController {

    private final CurrencyConversionService currencyService;
    private final UnitConversionService unitService;

    public ConversionController(CurrencyConversionService currencyService, UnitConversionService unitService) {
        this.currencyService = currencyService;
        this.unitService = unitService;
    }

    /**
     * Endpoint REST para conversão de moedas.
     * Recebe moedas e valor via query parameters, delega para CurrencyConversionService.convert().
     * Retorna ResponseEntity com ConversionDTO contendo resultado da conversão.
     */
    @Operation(summary = "Converte moedas", description = "Exemplo: USD para BRL")
    @GetMapping("/currency")
    public ResponseEntity<ConversionDTO> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        ConversionDTO result = currencyService.convert(from, to, amount);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Converte temperaturas", description = "Exemplo: C para F")
    @GetMapping("/unit/temperature")
    public ResponseEntity<ConversionDTO> convertTemperature(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double value) {

        ConversionDTO result = unitService.temperatureConverter(from, to, value);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Converte distâncias", description = "Exemplo: KM para MI")
    @GetMapping("/unit/distance")
    public ResponseEntity<ConversionDTO> convertDistance(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double value) {

        ConversionDTO result = unitService.convertDistance(from, to, value);
        return ResponseEntity.ok(result);
    }
}