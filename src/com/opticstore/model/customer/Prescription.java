package com.opticstore.model.customer;

import com.opticstore.model.AbstractModel;

public class Prescription extends AbstractModel {
	
	private static Integer prescriptionCounter = 0;

    private Double sphere;
    private Double cil;
    private Double axis;

    public Prescription(Double sphere, Double cil, Double axis) {
        super.setId(++prescriptionCounter);
        this.sphere = sphere;
        this.cil = cil;
        this.axis = axis;
    }

    public Double getSphere() {
        return sphere;
    }

    public Double getCil() {
        return cil;
    }

    public Double getAxis() {
        return axis;
    }
}
