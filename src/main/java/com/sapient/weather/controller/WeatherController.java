package com.sapient.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weather.model.ErrorResponse;
import com.sapient.weather.model.Prediction;
import com.sapient.weather.service.PredictionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {
	@Autowired
	private PredictionService predictionService;
	
	@GetMapping("/forecast")
	@ResponseStatus(HttpStatus.OK)
	public List<Prediction> getWeatherPrediction(@RequestParam String city) {
		log.info("Forecasting weather for city:"+city);
		return predictionService.predictWeather(city);
	}
	

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleException(Exception exp) {
		log.error("API Request failed due to following error:"+exp);
		return ErrorResponse.builder()
				.code(HttpStatus.INTERNAL_SERVER_ERROR.toString())
				.message("Api failed")
				.stackTrace(exp.toString())
				.build();	
	}
	

}
