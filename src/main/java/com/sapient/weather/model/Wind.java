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
public class Wind implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6179988152555696765L;
	private Double speed;
	private Double deg;
}
