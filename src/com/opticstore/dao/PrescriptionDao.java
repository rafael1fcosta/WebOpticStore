package com.opticstore.dao;

import org.springframework.stereotype.Component;

import com.opticstore.model.customer.Prescription;

@Component
public class PrescriptionDao extends AbstractDao<Prescription> {

    @Override
    public void add(Prescription prescription) {
        getLoggedInCustomer().getPrescriptionMap().put(prescription.getId(), prescription);
    }

    @Override
    public Prescription find(Prescription prescription) {
        return getLoggedInCustomer().getPrescriptionMap().get(prescription.getId());
    }

}
