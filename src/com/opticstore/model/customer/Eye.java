package com.opticstore.model.customer;

public enum Eye {
	RIGHT("Right"),
	LEFT("Left");
	
	String string;
	
	Eye(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
}
