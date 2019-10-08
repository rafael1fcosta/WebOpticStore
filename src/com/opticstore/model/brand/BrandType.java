package com.opticstore.model.brand;

import java.util.Collection;

public enum BrandType {

	FRAME("Frames"),
	CONTACTS("Contact Lens"), 
	LENS("Lens");
	
	//---------------------------------------------------------------------------------------------------
	
	private String name;
	
	private final String prefix = "<div class=\"col-lg-3\"><h1 class=\"my-4\"></h1><div class=\"list-group\" id=\"brands\">";
	
	private final String brandBegin = "<a href=\"http://localhost:8080/OpticStore/shop/filter/";
	
	private final String idBegin = "id=\"";
	private final String idEnd = "\">";
	
	private final String brandEnd = "</a>";
			
	private final String suffix = "</div></div>";
	
	//---------------------------------------------------------------------------------------------------
	
	BrandType(String name) {
		this.name = name;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public String createHtml(Collection<Brand> brands) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(prefix);
		
		brands.stream().forEach(b -> {
			builder.append(
					brandBegin + b.getType().toString() + "/" + b.getId() + "\" class=\"list-group-item\""
					+ idBegin + "brand" + b.getId() + idEnd + b.getName() + brandEnd);
		});
		
		builder.append(suffix);
		
		return builder.toString();
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name.toLowerCase().replace(" ", "-");
	}
}
