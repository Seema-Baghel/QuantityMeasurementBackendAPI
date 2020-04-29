package com.quantitymeasurement.model;

public class InputQuantityDTO {

    private IUnit unit;
    private Double value;

    public IUnit getUnit() {
        return unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setUnit(IUnit unit) {
        this.unit = unit;
    }

    public InputQuantityDTO(IUnit unit, Double value) {
        this.unit = unit;
        this.value = value;
    }
}
