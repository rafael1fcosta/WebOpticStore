package com.opticstore.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opticstore.model.ModelToHtml;
import com.opticstore.model.customer.Customer;
import com.opticstore.model.customer.Prescription;
import com.opticstore.service.ServiceImpl;

@Component
public class UtilForController {

	private ServiceImpl service;
	
	public Map<String, Object> addCustomerToModel() {
		
		Customer customer = service.getLoggedInCustomer();
		
		Map<String, Object> models = new HashMap<>();
		
		models.put("customer", customer);
		
		return models;
	}
	
	public Map<String, Object> addPrescriptionsToModel(Map<String, Object> models) {
		
		Map<Integer, Prescription> prescriptionMap = service.getPrescriptionMap();
		
		models.put("prescriptions", ModelToHtml.createPrescriptionList(prescriptionMap));
		
		return models;
	}
	
	public ServiceImpl getService() {
		return service;
	}

	@Autowired
	public void setService(ServiceImpl service) {
		this.service = service;
	}
}
