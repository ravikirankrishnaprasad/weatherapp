package com.sapient.weather.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherMain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2457001684599435521L;
	private BigInteger dt;
	private List<Weather> weather;
	private Cloud clouds;
	private Wind wind;
	@JsonProperty("dt_txt")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dtTxt;

}
