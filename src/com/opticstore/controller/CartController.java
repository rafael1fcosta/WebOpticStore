package com.opticstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.opticstore.service.ServiceImpl;

@Controller
public class CartController {
	
	private ServiceImpl service;
	private UtilForController util;

	//---------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/shop/cart")
	public ModelAndView cart() {
		
		if (service.getLoggedInCustomer() == null) {
			return new ModelAndView(new RedirectView("welcome"));
		}
		
		Map<String, Object> models = util.addCustomerToModel();
		
		System.out.print("-------works------");
		
		return new ModelAndView("cart", models);
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
