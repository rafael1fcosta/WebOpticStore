package com.opticstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.opticstore.service.ServiceImpl;

@Controller
public class CartController {
	
	private ServiceImpl service;
	private UtilForController util;

	//---------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/cart")
	public ModelAndView cart() {
		
		if (service.getLoggedInCustomer() == null) {
			return new ModelAndView(new RedirectView("welcome"));
		}
		
		Map<String, Object> models = util.addCustomerToModel();
		
		models.put("products", service.getProductListHtml());
		
		return new ModelAndView("cart", models);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping(path = "/cart", params = "delete")
	public ModelAndView deleteProduct(@RequestParam(name = "delete") Integer id) {
		
		Map<String, Object> models = util.addCustomerToModel();
		
		service.removeFromCart(id);
		
		models.put("products", service.getProductListHtml());
		
		return new ModelAndView("cart", models);
	}
	
	@PostMapping(path = "/cart", params = "add")
	public ModelAndView addPrescriptionToProduct(@RequestParam(name = "add") Integer prescrId) {
		
		if (prescrId == null) {
			return new ModelAndView(new RedirectView("cart"));
		}
		
		Map<String, Object> models = util.addCustomerToModel();
		
		service.addLens(prescrId);
		
		models.put("products", service.getProductListHtml());
		
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
