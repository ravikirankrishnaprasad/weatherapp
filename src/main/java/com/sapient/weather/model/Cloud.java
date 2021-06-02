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
public class Cloud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2379408348722983009L;
	private int all;

}
