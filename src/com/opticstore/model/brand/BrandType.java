package com.opticstore.model.brand;

public enum BrandType {

	FRAME("Frames"),
	CONTACTS("Contact Lens"), 
	LENS("Lens");
	
	//---------------------------------------------------------------------------------------------------
	
	private String name;
	
	public static final String prefix = "<div class=\"col-lg-3\"><h1 class=\"my-4\"></h1><div class=\"list-group\" id=\"brands\">";
	
	public static final String brandBegin = "<a href=\"http://localhost:8080/OpticStore/shop/filter/";
	
	public static final String idBegin = "id=\"";
	public static final String idEnd = "\">";
	
	public static final String brandEnd = "</a>";
			
	public static final String suffix = "</div></div>";
	
	//---------------------------------------------------------------------------------------------------
	
	BrandType(String name) {
		this.name = name;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public static BrandType getType(String string) {

		string = string.substring(0, string.length()-1);
		
		switch (string) {
			case "frames":
				return FRAME;
	
			default:
				return null;
		}
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name.toLowerCase().replace(" ", "-");
	}
}
