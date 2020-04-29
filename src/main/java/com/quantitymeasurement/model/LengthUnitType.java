package com.quantitymeasurement.model;

public enum LengthUnitType implements IUnit{

    FEET(12.0),
    INCH(1.0),
    YARD(36.0),
    CENTIMETER(0.4);

    public static final LengthUnitType baseType = INCH;

    public final double measurementValue;

    LengthUnitType(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        return this.measurementValue;
    }

    @Override
    public String getType() {
        return LengthUnitType.baseType.toString();
    }
}
