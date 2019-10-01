package com.opticstore.model.brand;

public class Brand {

	private String name;
	private int brandId;
	private BrandType type;
	
	private static int id = 1;
	
	public Brand(String name, BrandType type) {
		brandId = Brand.id;
		Brand.id++;
		this.name= name;
		this.type = type;
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
	
	public BrandType getType() {
		return type;
	}
}
