package com.opticstore.controller;

public enum AlertMessage {
	
	INVALID("Invalid Customer!"),
	DUPPLICATE("You already have an account!"),
	EMPTY("Please complete the form...");
	
	private String message;
	private final String prefix = "<div class=\"alert alert-danger\" role=\"alert\">";
	private final String suffix = " </div>";

	AlertMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return prefix + message + suffix;
	}
}
