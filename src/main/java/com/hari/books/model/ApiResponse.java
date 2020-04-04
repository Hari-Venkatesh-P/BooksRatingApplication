package com.hari.books.model;

public class ApiResponse {

	private String staus;
	private String message;
	private String value;
	
	public ApiResponse()
	{
		
	}
	
	public ApiResponse(String staus, String message, String value) {
		super();
		this.staus = staus;
		this.message = message;
		this.value = value;
	}
	public String getStaus() {
		return staus;
	}
	public void setStaus(String staus) {
		this.staus = staus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
