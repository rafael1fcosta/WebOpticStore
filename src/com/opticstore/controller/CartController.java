package com.opticstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.opticstore.model.brand.BrandType;
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
		
		models.put("products", service.getProductListToCart());
		
		return new ModelAndView("cart", models);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping(path = "/cart", params = "delete")
	public ModelAndView deleteProduct(@RequestParam(name = "delete") Integer id) {
		
		if (service.getLoggedInCustomer() == null) {
			RedirectView view = new RedirectView();
			view.setUrl("http://localhost:8080/OpticStore/welcome");
			
			return new ModelAndView(view);
		}
		
		Map<String, Object> models = util.addCustomerToModel();
		
		service.removeFromCart(id);
		
		models.put("products", service.getProductListToCart());
		
		return new ModelAndView("cart", models);
	}
	
	@PostMapping(path = "/cart", params = "add")
	public ModelAndView addPrescriptionToProduct(@RequestParam(name = "add") String input) {
		
		if (service.getLoggedInCustomer() == null) {
			RedirectView view = new RedirectView();
			view.setUrl("http://localhost:8080/OpticStore/welcome");
			
			return new ModelAndView(view);
		}
		
		if (input == null || input.isEmpty()) {
			return new ModelAndView(new RedirectView("cart"));
		}
		
		String[] inputArray = input.split(" ");
		
		Map<String, Object> models = util.addCustomerToModel();
		
		Integer prescId = Integer.valueOf(inputArray[0]);
		BrandType type = BrandType.getType(inputArray[1]);
		
		Integer price = 0;
		
		if (type == BrandType.FRAME) {
			price = 75;
		}
		
		service.addLens(prescId, price);
		
		models.put("products", service.getProductListToCart());
		
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
