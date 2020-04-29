package com.quantitymeasurement.model;

public enum VolumeUnitType implements IUnit{

    GALLON(3.78),LITRES(1),MILLILITERS(0.001);

    public static final VolumeUnitType baseType = LITRES;

    public final double measurementValue;

    VolumeUnitType(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        return this.measurementValue;
    }

    @Override
    public String getType() {
        return VolumeUnitType.baseType.toString();
    }
}
