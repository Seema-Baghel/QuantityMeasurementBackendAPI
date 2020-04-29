package com.quantitymeasurement.controller;

import com.quantitymeasurement.model.InputQuantityDTO;
import com.quantitymeasurement.model.OutputQuantityDTO;
import com.quantitymeasurement.service.QuantityMeasurement;
import com.quantitymeasurement.service.EnumPovider;
import com.quantitymeasurement.service.QuantityMeasurementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class QuantityMeasurementController {

    @Autowired
    private QuantityMeasurement quantityMeasurement;

    @Autowired
    private EnumPovider provider;

    @GetMapping("/compare")
    public String compareUnits(@RequestParam(value = "measurementUnit1")String measurementUnit1, @RequestParam(value = "measurementValue1")Double measurementValue1,
                               @RequestParam (value = "measurementUnit2")String measurementUnit2, @RequestParam(value = "measurementValue2")Double measurementValue2) throws QuantityMeasurementException {

        InputQuantityDTO inputQuantityDTO1 = new InputQuantityDTO(provider.getType(measurementUnit1), measurementValue1);
        InputQuantityDTO inputQuantityDTO2 = new InputQuantityDTO(provider.getType(measurementUnit2), measurementValue2);
        String compareResult = new OutputQuantityDTO(quantityMeasurement.compareUnits(inputQuantityDTO1, inputQuantityDTO2), inputQuantityDTO1, inputQuantityDTO2).getComparedResult();
        return compareResult;
    }

    @PostMapping("/temperature")
    public String temperatureConversion(@RequestParam (value = "measurementUnit1")String measurementUnit1,@RequestParam(value = "measurementValue1")Double measurementValue1,
                                        @RequestParam (value = "measurementUnit2")String measurementUnit2,@RequestParam(value = "measurementValue2")Double measurementValue2) {
        try {
            InputQuantityDTO inputQuantityDTO1 = new InputQuantityDTO(provider.getType(measurementUnit1), measurementValue1);
            InputQuantityDTO inputQuantityDTO2 = new InputQuantityDTO(provider.getType(measurementUnit2), measurementValue2);
            String compareResult = null;
            compareResult = new OutputQuantityDTO(quantityMeasurement.temperatureConversion(inputQuantityDTO1, inputQuantityDTO2), inputQuantityDTO1, inputQuantityDTO2).getComparedResult();
            return compareResult;
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/addUnits")
    public String addUnits(@RequestParam (value = "measurementUnit1")String measurementUnit1, @RequestParam(value = "measurementValue1")Double measurementValue1,
                           @RequestParam (value = "measurementUnit2")String measurementUnit2, @RequestParam(value = "measurementValue2")Double measurementValue2) {
        try {
            InputQuantityDTO inputQuantityDTO1 = new InputQuantityDTO(provider.getType(measurementUnit1), measurementValue1);
            InputQuantityDTO inputQuantityDTO2 = new InputQuantityDTO(provider.getType(measurementUnit2), measurementValue2);
            String compareResult = null;
            compareResult = new OutputQuantityDTO(quantityMeasurement.addUnits(inputQuantityDTO1, inputQuantityDTO2), inputQuantityDTO1, inputQuantityDTO2).getAddedResult();
            return compareResult;
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
