package com.opticstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.opticstore.model.customer.Prescription;
import com.opticstore.service.ServiceImpl;

@Controller
public class CustomerPageController {

	private ServiceImpl service;
	private UtilForController util;
	
	//---------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/customerPage")
	public ModelAndView customerPage() {
		
		if (service.getLoggedInCustomer() == null) {
			return new ModelAndView(new RedirectView("welcome"));
		}
		
		Map<String, Object> models = util.addCustomerToModel();
		
		if (!service.isPrescriptionMapEmpty()) {
			models = util.addPrescriptionsToModel(models);
		}
		
		return new ModelAndView("customerPage", models);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping(path="/customerPage")
	public ModelAndView addPrescription() {
		
		return new ModelAndView("/newPrescriptionPage", util.addCustomerToModel());
	}
	
	@PostMapping(path="/customerPage", params = "save")
	public ModelAndView savePrescription(Prescription prescription) {
		
		Map<String, Object> models = util.addCustomerToModel();		
		
		if(prescription.getSphere() == null 
				|| prescription.getCil() == null 
				|| prescription.getAxis() == null) {
			models.put("alert", AlertMessage.EMPTY.getMessage());
			return new ModelAndView("newPrescriptionPage", models);
		}
		
		service.addPrescription(prescription);
		

		models = util.addPrescriptionsToModel(models);

		return new ModelAndView("customerPage", models);
	}
	
	//---------------------------------------------------------------------------------------------------

	@Autowired
	public void setService(ServiceImpl service) {
		this.service = service;
	}
	
	@Autowired
	public void setUtil(UtilForController util) {
		this.util = util;
	}
}
