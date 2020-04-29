package com.quantitymeasurement.service;

import com.quantitymeasurement.model.InputQuantityDTO;
import com.quantitymeasurement.model.TemperatureUnitType;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementService implements QuantityMeasurement {

    public QuantityMeasurementService() { }

    @Override
    public Boolean compareUnits(InputQuantityDTO measurement1, InputQuantityDTO measurement2) throws QuantityMeasurementException {
        if (!measurement1.getUnit().getClass().equals(measurement2.getUnit().getClass())) {
            throw new QuantityMeasurementException("Not_Balanced", QuantityMeasurementException.ExceptionType.Not_Balanced);
        }
        double unit1 = Math.round(measurement1.getValue() * measurement1.getUnit().conversion());
        double unit2 = Math.round(measurement2.getValue() * measurement2.getUnit().conversion());
        return Double.compare(unit1, unit2)  == 0;
    }

    @Override
    public double addUnits(InputQuantityDTO measurement1, InputQuantityDTO measurement2) throws QuantityMeasurementException {
        if (!measurement1.getUnit().getClass().equals(measurement2.getUnit().getClass())) {
            throw new QuantityMeasurementException("Not_Balanced", QuantityMeasurementException.ExceptionType.Not_Balanced);
        }
        return ((measurement1.getValue() * measurement1.getUnit().conversion()) + (measurement2.getValue() * measurement2.getUnit().conversion()));
    }

    @Override
    public Boolean temperatureConversion(InputQuantityDTO measurement1, InputQuantityDTO measurement2) throws QuantityMeasurementException {
        if (!measurement1.getUnit().getClass().equals(measurement2.getUnit().getClass())) {
            throw new QuantityMeasurementException("Not_Balanced", QuantityMeasurementException.ExceptionType.Not_Balanced);
        }
        if (measurement1.getUnit().equals(TemperatureUnitType.CELSIUS))
            return Double.compare(Math.round(measurement1.getValue() - TemperatureUnitType.FAHRENHEIT.measurementValue * (5 / 9)), Math.round(measurement1.getValue())) == 0;
        return Double.compare(Math.round((measurement2.getValue() * 9 / 5)+ 32) , Math.round(measurement1.getValue())) == 0;
    }
}
