package com.opticstore.model.product;

import com.opticstore.model.AbstractModel;
import com.opticstore.model.brand.Brand;

public class Product extends AbstractModel {
	
	private String name;
	private Brand brand;
	private Double price;
	
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

}
