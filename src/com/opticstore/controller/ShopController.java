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
		
		Map<String, Object> models = util.addCustomerToModel();
		StringBuilder builder = new StringBuilder();
		
		switch(option) {
			case "frames":
				models.put("type", BrandType.FRAME.getName());
				models.put("options", ShopOptionsProducer.FRAME.createHtml(service.getBrands(BrandType.FRAME)));
				
				service.getProducts(BrandType.FRAME)
					.stream().forEach(p -> builder.append(ShopProductsProducer.creatHtml(p)));
				
				models.put("products", builder.toString());
				break;
				
			case "contacts":
				models.put("type", BrandType.CONTACTS.getName());
				models.put("options", ShopOptionsProducer.CONTACTS.createHtml(service.getBrands(BrandType.CONTACTS)));
				
				service.getProducts(BrandType.CONTACTS)
					.stream().forEach(p -> builder.append(ShopProductsProducer.creatHtml(p)));
				
				models.put("products", builder.toString());
				break;
			default:
				break;
				/*models.put("type", ShopOptionsProducer.TEST_ONLY.getType());
				models.put("options", ShopOptionsProducer.TEST_ONLY.createHtml(service.getBrands(ShopOptionsProducer.TEST_ONLY)));*/
		}
		
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
