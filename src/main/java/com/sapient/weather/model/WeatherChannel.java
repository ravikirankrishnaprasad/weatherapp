package com.sapient.weather.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherChannel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6107190177780272026L;
	private String code;
	private Double message;
	private int cnt;
	private List<WeatherMain> list;

}
