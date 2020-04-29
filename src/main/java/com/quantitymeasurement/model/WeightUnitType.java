package com.quantitymeasurement.model;

public enum WeightUnitType implements IUnit{

    KILOGRAMS(1.0), GRAMS(1d/1000), TONNES(1000);

    public static final WeightUnitType baseType = KILOGRAMS;

    public final double measurementValue;

    WeightUnitType(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        return this.measurementValue;
    }

    @Override
    public String getType() {
        return WeightUnitType.baseType.toString();
    }
}
