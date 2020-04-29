package com.quantitymeasurement.controller;

import com.quantitymeasurement.model.InputQuantityDTO;
import com.quantitymeasurement.model.LengthUnitType;
import com.quantitymeasurement.model.TemperatureUnitType;
import com.quantitymeasurement.model.WeightUnitType;
import com.quantitymeasurement.service.QuantityMeasurement;
import com.quantitymeasurement.service.QuantityMeasurementException;
import com.quantitymeasurement.service.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

public class QuantityMeasurementControllerTest {

    @Mock
    QuantityMeasurement quantityMeasurement = mock(QuantityMeasurementService.class);


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    QuantityMeasurementController controller = new QuantityMeasurementController();


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenInputDataAndUnitType_ShouldReturnString() {
        try {
            InputQuantityDTO inputQuantityDTO1 = new InputQuantityDTO(LengthUnitType.FEET,1.0);
            InputQuantityDTO inputQuantityDTO2 = new InputQuantityDTO(LengthUnitType.INCH,12.0);
            Boolean expectedOutput =true;
            Mockito.when( quantityMeasurement.compareUnits(inputQuantityDTO1, inputQuantityDTO2)).thenReturn(expectedOutput);
            Assert.assertEquals(expectedOutput,
                    quantityMeasurement.compareUnits(inputQuantityDTO1, inputQuantityDTO2));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenInputDataAndUnitTypeToAdd_ShouldReturnString() {
        try {
            InputQuantityDTO inputQuantityDTO1 = new InputQuantityDTO(LengthUnitType.FEET,1.0);
            InputQuantityDTO inputQuantityDTO2 = new InputQuantityDTO(LengthUnitType.FEET,2.0);
            double expectedOutput = 36.0;
            Mockito.when( quantityMeasurement.addUnits(inputQuantityDTO1, inputQuantityDTO2)).thenReturn(expectedOutput);
            Assert.assertEquals(expectedOutput,quantityMeasurement.addUnits(inputQuantityDTO2,inputQuantityDTO1),expectedOutput);
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenInputDataAndUnitTypeAsTemperature_ShouldReturnString() {
        try {
            InputQuantityDTO inputQuantityDTO1 = new InputQuantityDTO(TemperatureUnitType.FAHRENHEIT,212.0);
            InputQuantityDTO inputQuantityDTO2 = new InputQuantityDTO(TemperatureUnitType.CELSIUS,100.0);
            Boolean expectedOutput = true;
            Mockito.when( quantityMeasurement.temperatureConversion(inputQuantityDTO1, inputQuantityDTO2)).thenReturn(expectedOutput);
            Assert.assertEquals(expectedOutput,quantityMeasurement.temperatureConversion(inputQuantityDTO1,inputQuantityDTO2));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }
}
