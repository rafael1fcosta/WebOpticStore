package com.opticstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		
		StringBuilder builder = new StringBuilder();
		
		prescriptionMap.values().stream().forEach(p ->
			builder.append(
					"<tr>"
					+ "<th scope='row'>" + p.getId()  + "</th>"
					+ "<td>" + p.getSphere() + "</td>"
					+ "<td>" + p.getCil() + "</td>"
					+ "<td>" + p.getAxis() + "</td>"
					+ "</tr>"
					)
		);

		models.put("prescriptions", builder.toString());
		
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
