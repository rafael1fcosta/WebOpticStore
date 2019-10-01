package com.opticstore.model.brand;

public enum BrandType {

	FRAME("Frames"),
	CONTACTS("Contact Lens");
	
	private String name;
	
	BrandType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
