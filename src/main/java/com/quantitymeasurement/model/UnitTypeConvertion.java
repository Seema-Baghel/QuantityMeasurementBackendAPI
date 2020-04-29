package com.quantitymeasurement.model;

public class UnitTypeConvertion {

    private IUnit unit;
    private Double value;


    private LengthUnitType lengthUnits;

    private VolumeUnitType volumeUnits;

    private WeightUnitType weightUnits;

    private TemperatureUnitType temperatureUnit;

    public UnitTypeConvertion(IUnit unit, Double value) {
        this.unit = unit;
        this.value = value;
    }

    public LengthUnitType getLengthUnits() {
        return lengthUnits;
    }

    public UnitTypeConvertion() {
    }

    public VolumeUnitType getVolumeUnits() {
        return volumeUnits;
    }

    public WeightUnitType getWeightUnits() {
        return weightUnits;
    }

    public TemperatureUnitType getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setLengthUnits(LengthUnitType lengthUnits) {
        this.lengthUnits = lengthUnits;
    }

    public void setVolumeUnits(VolumeUnitType volumeUnits) {
        this.volumeUnits = volumeUnits;
    }

    public void setWeightUnits(WeightUnitType weightUnits) {
        this.weightUnits = weightUnits;
    }

    public void setTemperatureUnit(TemperatureUnitType temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public IUnit getUnit() {
        return unit;
    }

    public Double getValue() {
        return value;
    }
}
