package com.opticstore.model.product;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.opticstore.model.AbstractModel;
import com.opticstore.model.brand.Brand;

public class Product extends AbstractModel {
	
	private String name;
	private Brand brand;
	private Double price;
	private Integer imgId;
	
	private static int productId = 0;
	
	public Product(String name, Brand brand, Double price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		productId++;
		setId(productId);
	}

	public Brand getBrand() {
		return brand;
	}

	public Double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	public Integer getImgId() {
		return imgId;
	}
	
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	
	public static String creatHtml(Product product) {
		
		return 
				"<div class=\"col-lg-4 col-md-6 mb-4\" id=\"product" + product.getId() + "\" brand=\"" + product.getBrand().toString() + "\">"
				+ "<div class=\"card h-100\">"
				+ 	"<a href=\"#\"><img class=\"card-img-top\" src=\"http://localhost:8080/OpticStore/resources/" + product.getBrand().getType() + product.getImgId() + ".jpg\" alt=\"\"></a>"
				+ 	"<div class=\"card-body\">"
				+ 		"<h4 class=\"card-title\">"
				+ 			"<a href=\"#\">" + product.getName() + "</a>"
				+ 		"</h4>"
				+ 		"<h5>" + new BigDecimal(product.getPrice()).setScale(2, RoundingMode.HALF_UP) + "&euro;</h5>"
				+ 		"<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur"
				+ 			"adipisicing elit. Amet numquam aspernatur!</p>"
				+ 	"</div>"
				+ 	"<form method=\"post\">"
				+		"<input type=\"hidden\" name=\"addToCart\" value=\"" + product.getId() + "\">"
				+  		"<button type=\"submit\" class=\"btn btn-warning\" value=\"submit\" style=\"margin: 0px 0px 20px 20px;\">"
				+ 			"Add to cart!"
				+ 		"</button>"
				+ 	"</form>"
				+ "</div>"
				+"</div>";
	}
}
