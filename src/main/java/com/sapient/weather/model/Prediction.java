package com.sapient.weather.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Prediction {
	private String city;
	private LocalDateTime date;
	private String prediction;
}
