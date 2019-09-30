package com.opticstore.controller;

import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.opticstore.model.product.Product;
import com.opticstore.service.ServiceImpl;

@Controller
public class ShopController {

	private ServiceImpl service;
	private UtilForController util;
	
	//---------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/shop/{option}")
	public ModelAndView toShopForFrames(@PathVariable String option) {
		
		Map<String, Object> models = util.addCustomerToModel();
		
		switch(option) {
			/*case "frames":
				models.put("options", ShopOptions.FRAME.createHtml(service.getBrands(ShopOptions.FRAME)));
				break;
			case "contacts":
				models.put("options", ShopOptions.CONTACTS.createHtml(service.getBrands(ShopOptions.CONTACTS)));
				break;*/
			default:
				models.put("options", ShopOptionsProducer.TEST_ONLY.createHtml(service.getBrands(ShopOptionsProducer.TEST_ONLY)));
		}
		
		//for test
		StringBuilder builder = new StringBuilder();
		
		service.getBrands(ShopOptionsProducer.TEST_ONLY)
			.stream()
			.forEach(b -> builder.append(ShopProductsProducer.creatHtml(new Product(b))));
		
		models.put("products", builder.toString());
		
		return new ModelAndView("shop", models);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------
	
	@Autowired
	public void setUtil(UtilForController util) {
		this.util = util;
	}

	@Autowired
	public void setService(ServiceImpl service) {
		this.service = service;
	}
}
