package com.opticstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.opticstore.model.customer.Customer;
import com.opticstore.service.ServiceImpl;

@Controller
public class MainController {
	
	private ServiceImpl service;
	
	//---------------------------------------------------------------------------------------------------

	@GetMapping(path = {"/welcome", "/"})
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping(path = "{a}/logout")
	public String logOut() {
		service.logOut();
		return "redirect:/welcome";
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping(path = "/welcome")
	public ModelAndView getUserName(Customer customer) {
		
		if (customer.getId() == null || customer.getName() == null) {
			return new ModelAndView("welcome", "alert", AlertMessage.EMPTY.getMessage());
		}
		
		if (!service.authenticate(customer)) {
			return new ModelAndView("welcome", "alert", AlertMessage.INVALID.getMessage());
		}
		
		return new ModelAndView(new RedirectView("customerPage"));
	}
	
	@PostMapping(path="/welcome", params = "newCustomer")
	public ModelAndView addNewCustomer(Customer customer) {
		
		if (customer.getId() == null || customer.getName() == null) {
			return new ModelAndView("welcome", "alert", AlertMessage.EMPTY.getMessage());
		}
		
		if (service.clientInDatabase(customer)) {
			return new ModelAndView("welcome", "alert", AlertMessage.DUPPLICATE.getMessage());
		}
		
		service.addCustomer(customer);
		
		return new ModelAndView("newCustomerPage");
	}
	
	//---------------------------------------------------------------------------------------------------

	@Autowired
	public void setService(ServiceImpl service) {
		this.service = service;
	}
}
