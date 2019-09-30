package com.opticstore.model.product;

import com.opticstore.model.AbstractModel;
import com.opticstore.model.brand.Brand;

public class Product extends AbstractModel {
	
	private Brand brand;
	
	private static int productId = 0;
	
	public Product(Brand brand) {
		this.brand = brand;
		productId++;
		setId(productId);
	}

	public Brand getBrand() {
		return brand;
	}

}
