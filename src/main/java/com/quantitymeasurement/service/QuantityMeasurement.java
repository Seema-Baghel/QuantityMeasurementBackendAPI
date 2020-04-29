package com.quantitymeasurement.service;

import com.quantitymeasurement.model.InputQuantityDTO;

public interface QuantityMeasurement {

     Boolean compareUnits(InputQuantityDTO measurement1, InputQuantityDTO measurement2) throws QuantityMeasurementException;

     double addUnits(InputQuantityDTO measurement1, InputQuantityDTO measurement2) throws QuantityMeasurementException;

     Boolean temperatureConversion(InputQuantityDTO measurement1, InputQuantityDTO measurement2) throws QuantityMeasurementException;
}
