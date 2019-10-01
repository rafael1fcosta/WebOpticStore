package com.opticstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

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
		
		BrandType brandTypeChoosen = getBrandTypeChoosen(option);
		
		Map<String, Object> models = util.addCustomerToModel();
		
		models = addBrandTypeOptions(brandTypeChoosen, models);
		
		StringBuilder builder = new StringBuilder();
		
		service.getProducts(brandTypeChoosen)
			.stream().forEach(p -> builder.append(Product.creatHtml(p)));
		
		models.put("products", builder.toString());
		
		return new ModelAndView("shop", models);
	}
	
	
	@GetMapping(path = "/shop/filter/{type}/{id}")
	public ModelAndView filterProducts(@PathVariable String type, @PathVariable Integer id) {
		
		BrandType brandTypeChoosen = getBrandTypeChoosen(type);
		
		Map<String, Object> models = util.addCustomerToModel();
		
		models = addBrandTypeOptions(brandTypeChoosen, models);
		
		StringBuilder builder = new StringBuilder();
		
		service.getProducts(brandTypeChoosen)
			.stream()
			.filter(p -> p.getBrand().getId() == id)
			.forEach(p -> builder.append(Product.creatHtml(p)));
	
		models.put("products", builder.toString());
		
		return new ModelAndView("shop", models);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------
	
	private Map<String, Object> addBrandTypeOptions(BrandType brandTypeChoosen, Map<String, Object> models) {
		
		models.put("type", brandTypeChoosen.getName());
		models.put("options", brandTypeChoosen.createHtml(service.getBrands(brandTypeChoosen)));
		
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

