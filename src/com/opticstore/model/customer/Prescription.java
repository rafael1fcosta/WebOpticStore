package com.opticstore.model.customer;

import com.opticstore.model.AbstractModel;

public class Prescription extends AbstractModel {
	
	private static Integer prescriptionCounter = 0;

    private Double sphere;
    private Double cil;
    private Double axis;
    private Eye eye;
    
    // -----------------------------------------------------------------------------------------------------------------

    public Prescription(Double sphere, Double cil, Double axis, String eye) {
        super.setId(++prescriptionCounter);
        this.sphere = sphere;
        this.cil = cil;
        this.axis = axis;
        switch (eye) {
	        case "right":
				this.eye = Eye.RIGHT;
				break;
				
			case "left":
				this.eye = Eye.LEFT;
				break;
		}
    }

    // -----------------------------------------------------------------------------------------------------------------
    
    public Double getSphere() {
        return sphere;
    }

    public Double getCil() {
        return cil;
    }

    public Double getAxis() {
        return axis;
    }
    
    public Eye getEye() {
    	return this.eye;
    }
}