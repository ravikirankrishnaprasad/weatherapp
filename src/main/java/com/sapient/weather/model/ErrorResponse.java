package com.sapient.weather.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
	private String code;
	private String message;
	private String stackTrace;
}
