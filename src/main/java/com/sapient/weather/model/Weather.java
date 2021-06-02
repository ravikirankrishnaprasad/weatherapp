package com.sapient.weather.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3467105628196567996L;
	private int id;
	private String main;
	private String description;
	private String icon;	
}
