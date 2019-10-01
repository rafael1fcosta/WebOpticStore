package com.opticstore.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.opticstore.model.product.Product;

public abstract class ShopProductsProducer {
	
	public static String creatHtml(Product product) {
		
		return 
				"<div class=\"col-lg-4 col-md-6 mb-4\" id=\"product" + product.getId() + "\" brand=\"" + product.getBrand().toString() + "\">"
				+ "<div class=\"card h-100\">"
				+ 	"<a href=\"#\"><img class=\"card-img-top\" src=\"http://placehold.it/700x400\" alt=\"\"></a>"
				+ 	"<div class=\"card-body\">"
				+ 		"<h4 class=\"card-title\">"
				+ 			"<a href=\"#\">" + product.getName() + "</a>"
				+ 		"</h4>"
				+ 		"<h5>" + new BigDecimal(product.getPrice()).setScale(2, RoundingMode.HALF_UP) + "&euro;</h5>"
				+ 		"<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur"
				+ 			"adipisicing elit. Amet numquam aspernatur!</p>"
				+ 	"</div>"
				+  	"<button type=\"button\" class=\"btn btn-warning\" style=\"margin: 15px;\">"
				+ 		"<a href=\"http://localhost:8080/OpticStore/shop/cart/" + product.getId() + "\">Add to cart!</a>"
				+ 	"</button>"

				+ "</div>"
				+"</div>";
	}
	
}
