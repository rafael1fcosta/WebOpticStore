package com.opticstore.controller;

import java.util.Collection;

import com.opticstore.model.brand.Brand;

public enum ShopOptionsProducer {

	FRAME("Frames"),
	CONTACTS("Contacts"),
	TEST_ONLY("Test only");
	
	private String type;
	private final String prefixBegin = "<div class=\"col-lg-3\"><h1 class=\"my-4\">";
	private final String prefixEnd = "</h1><div class=\"list-group\" id=\"brands\">";
	
	private final String brandBegin = "<a href=\"#\" class=\"list-group-item\"";
	
	private final String idBegin = "id=\"";
	private final String idEnd = "\">";
	
	private final String brandEnd = "</a>";
			
	private final String suffix = "</div></div>";
	
	private ShopOptionsProducer(String type) {
		this.type = type;
	}
	
	public String createHtml(Collection<Brand> brands) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(prefixBegin + type + prefixEnd);
		
		brands.stream().forEach(b -> builder.append(brandBegin + idBegin + "brand" + b.getId() + idEnd + b.getName() + brandEnd));
		
		builder.append(suffix);
		
		return builder.toString();
	}
}
