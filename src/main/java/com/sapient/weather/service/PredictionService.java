package com.sapient.weather.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather.constants.WeatherResponse;
import com.sapient.weather.model.Prediction;
import com.sapient.weather.model.WeatherChannel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PredictionService {
	@Value("${app.weather.api.url}")
	private String url;
	@Value("${app.weather.api.key}")
	private String key;

	public List<Prediction> predictWeather(String city) {

		RestTemplate restTemplate = new RestTemplate();
		WeatherChannel weatherChannel = restTemplate.getForObject(url+"?q="+city+"&appid="+key, WeatherChannel.class);
		log.info("Successfully fetched data from weather channel");
	
		//Note: Tested for city London and it is not having latest data and hence result is coming as null
		return weatherChannel.getList().stream()
				.filter(d -> d.getDtTxt()!= null)
				.filter(d -> d.getDtTxt().isAfter(LocalDateTime.now()) && d.getDtTxt().isBefore(LocalDateTime.now().plusDays(3)))
				.map(d -> Prediction.builder()
						.city(city)
						.date(d.getDtTxt())
						.prediction(d.getWeather().get(0).getMain().equals("Rain")?WeatherResponse.RAINY_DAY.getResponse():WeatherResponse.SUNNY_DAY.getResponse())
						.build())
				.collect(Collectors.toList());
	}

}
