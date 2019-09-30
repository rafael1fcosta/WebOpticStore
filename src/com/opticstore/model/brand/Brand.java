package com.opticstore.model.brand;

public class Brand {

	private String name;
	private int brandId;
	
	private static int id = 1;
	
	public Brand(String name) {
		brandId = Brand.id;
		Brand.id++;
		this.name= name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return brandId;
	}
	
	@Override
	public String toString() {
		return name.replace(" ", "");
	}
}
