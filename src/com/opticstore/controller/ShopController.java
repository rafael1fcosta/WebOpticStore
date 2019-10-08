package com.opticstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.opticstore.model.ModelToHtml;
import com.opticstore.model.brand.BrandType;
import com.opticstore.model.product.Product;
import com.opticstore.service.ServiceImpl;

@Controller
public class ShopController {

	private ServiceImpl service;
	private UtilForController util;
	
	//---------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/shop/{option}")
	public ModelAndView toShopForFrames(@PathVariable String option) {
		
		if (service.getLoggedInCustomer() == null) {
			return new ModelAndView(new RedirectView("welcome"));
		}
		
		BrandType brandTypeChoosen = getBrandTypeChoosen(option);
		
		Map<String, Object> models = util.addCustomerToModel();
		
		models = addBrandTypeOptions(brandTypeChoosen, models);
		
		StringBuilder builder = new StringBuilder();
		
		service.getProducts(brandTypeChoosen)
			.stream().forEach(p -> builder.append(ModelToHtml.createProductHtml(p)));
		
		models.put("products", builder.toString());
		
		return new ModelAndView("shop", models);
	}
	
	
	@GetMapping(path = "/shop/filter/{type}/{id}")
	public ModelAndView filterProducts(@PathVariable String type, @PathVariable Integer id) {
		
		if (service.getLoggedInCustomer() == null) {
			return new ModelAndView(new RedirectView("welcome"));
		}
		
		BrandType brandTypeChoosen = getBrandTypeChoosen(type);
		
		Map<String, Object> models = util.addCustomerToModel();
		
		models = addBrandTypeOptions(brandTypeChoosen, models);
		
		StringBuilder builder = new StringBuilder();
		
		service.getProducts(brandTypeChoosen)
			.stream()
			.filter(p -> p.getBrand().getId() == id)
			.forEach(p -> builder.append(ModelToHtml.createProductHtml(p)));
	
		models.put("products", builder.toString());
		
		return new ModelAndView("shop", models);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping(path = {"shop/{type}", "shop/filter/{type}/{id}"})
	public String addToCart(@PathVariable String type, @RequestParam(name = "addToCart") Integer id) {
		
		service.addToCart(id);
		
		return "redirect:/shop/" + type;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	private Map<String, Object> addBrandTypeOptions(BrandType brandTypeChoosen, Map<String, Object> models) {
		
		models.put("type", brandTypeChoosen.getName());
		models.put("options", ModelToHtml.createBrandTypeList(service.getBrands(brandTypeChoosen)));
		
		return models;
	}
	
	private BrandType getBrandTypeChoosen(String option) {
		
		switch(option) {
		
			case "frames":
				return BrandType.FRAME;
				
			case "contact-lens":
				return BrandType.CONTACTS;
				
			default:
				return null;
		}
	}
	
	@Autowired
	public void setUtil(UtilForController util) {
		this.util = util;
	}

	@Autowired
	public void setService(ServiceImpl service) {
		this.service = service;
	}
}

