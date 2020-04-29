package com.quantitymeasurement.service;

public class QuantityMeasurementException extends Exception {
    public ExceptionType type;

    public enum ExceptionType{
        Not_Balanced;
    }

    public QuantityMeasurementException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public QuantityMeasurementException(ExceptionType type) {
        this.type = type;
    }
}
