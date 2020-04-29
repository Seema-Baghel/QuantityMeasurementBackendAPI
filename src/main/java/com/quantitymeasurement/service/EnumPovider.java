package com.quantitymeasurement.service;

import com.quantitymeasurement.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class EnumPovider {
    private final HashMap<String, IUnit> unitHashMap;

    public EnumPovider() {
        this.unitHashMap = new HashMap<>();
        unitHashMap.put("FEET", LengthUnitType.FEET);
        unitHashMap.put("INCH", LengthUnitType.INCH);
        unitHashMap.put("YARD", LengthUnitType.YARD);
        unitHashMap.put("CENTIMETER", LengthUnitType.CENTIMETER);
        unitHashMap.put("GALLON", VolumeUnitType.GALLON);
        unitHashMap.put("LITRES", VolumeUnitType.LITRES);
        unitHashMap.put("MILLILITERS", VolumeUnitType.MILLILITERS);
        unitHashMap.put("KILOGRAMS", WeightUnitType.KILOGRAMS);
        unitHashMap.put("GRAMS", WeightUnitType.GRAMS);
        unitHashMap.put("TONNES", WeightUnitType.TONNES);
        unitHashMap.put("FAHRENHEIT", TemperatureUnitType.FAHRENHEIT);
        unitHashMap.put("CELSIUS", TemperatureUnitType.CELSIUS);
    }

    public IUnit getType(String unit1) {
        return unitHashMap.get(unit1);
    }

}
