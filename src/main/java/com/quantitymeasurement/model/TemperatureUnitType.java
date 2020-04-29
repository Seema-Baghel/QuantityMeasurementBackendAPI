package com.quantitymeasurement.model;

public enum TemperatureUnitType implements IUnit {

    FAHRENHEIT(32.0), CELSIUS(1.0);

    public static final TemperatureUnitType baseType = CELSIUS;

    public final double measurementValue;

    TemperatureUnitType(Double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        if (this.equals(FAHRENHEIT))
            return FAHRENHEIT.measurementValue;
        return CELSIUS.measurementValue;
    }

    @Override
    public String getType() {
        return TemperatureUnitType.baseType.toString();
    }
}

