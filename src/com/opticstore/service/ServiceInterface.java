package com.opticstore.service;

import com.opticstore.dao.AbstractDao;
import com.opticstore.model.customer.Customer;
import com.opticstore.model.customer.Prescription;

public interface ServiceInterface {

    boolean authenticate(Customer customer);

    boolean clientHasPrescription();

    void setClientPrescription(Double sphere, Double cil, Double axis);

    void setCustomerDao(AbstractDao<Customer> customerDao);

    void setPrescriptionDao(AbstractDao<Prescription> prescriptionDao);
}
