package com.wxrley.conversionapi.dto;

/**
 * DTO de transferência entre Controller e Cliente.
 * Padroniza estrutura de respostas da API.
 */
public class ConversionDTO {

    private String from;
    private String to;
    private double originalValue;
    private double convertedValue;
    private String conversionType;

    public ConversionDTO(String from, String to, double originalValue, double convertedValue, String conversionType) {
        this.from = from;
        this.to = to;
        this.originalValue = originalValue;
        this.convertedValue = convertedValue;
        this.conversionType = conversionType;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getOriginalValue() {
        return originalValue;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public String getConversionType() {
        return conversionType;
    }
}