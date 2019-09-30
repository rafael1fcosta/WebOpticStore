package com.opticstore.model.customer;

import java.util.HashMap;
import java.util.Map;

import com.opticstore.model.AbstractModel;

public class Customer extends AbstractModel{

    private static Integer customerCounter = 0;

    private String name;
    private Map<Integer, Prescription> prescriptionMap;
    
    public Customer() {
    	this.prescriptionMap = new HashMap<>();
    }

    public Customer(String name) {
        super.setId(++customerCounter);
        this.name = name;
        this.prescriptionMap = new HashMap<>();
    }

    public Map<Integer, Prescription> getPrescriptionMap() {
        return prescriptionMap;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
}
