package com.quantitymeasurement.model;

public class OutputQuantityDTO {

    private Object result;
    private InputQuantityDTO quantity1;
    private InputQuantityDTO quantity2;

    public OutputQuantityDTO(Object result, InputQuantityDTO quantity1, InputQuantityDTO quantity2) {
        this.result = result;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
    }

    public String getComparedResult(){
        return this.getInputAsString() + "\nresult : " + (Boolean)result;
    }

    public  String getAddedResult() {
        return this.getInputAsString() + "\nresult: " + (Double)result + quantity1.getUnit().getType();
    }

    private String getInputAsString() {
        return "\nmeasurement1" + " " +  quantity1.getUnit() + " " + quantity1.getValue()
                +  "\nmeasurement2" + " " +  quantity2.getUnit() + " " + quantity2.getValue();
    }
}
