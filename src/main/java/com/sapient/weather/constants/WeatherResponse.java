package com.sapient.weather.constants;

public enum WeatherResponse {
	RAINY_DAY("Carry umbrella"),SUNNY_DAY("Use sunscreen lotion");
	
	private String response;
	WeatherResponse(String response){
		this.response=response;
	}
	
	public String getResponse() {
		return this.response;
	}

}
