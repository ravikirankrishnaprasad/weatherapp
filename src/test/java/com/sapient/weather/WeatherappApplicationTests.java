package com.sapient.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.sapient.weather.model.Prediction;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherappApplicationTests {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testWeatherAppForValidCity() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	    ResponseEntity<Prediction> response = restTemplate.exchange(
	    createURLWithPort("/weather/forecast?city=London,us"), HttpMethod.GET, entity, Prediction.class);

	    assertEquals("200",response.getStatusCode());
		
	}
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

	@Test
	public void testWeatherAppForInvalidCity() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	    ResponseEntity<Prediction> response = restTemplate.exchange(
	    createURLWithPort("/weather/forecast?city=qwrdvdfvdfg"), HttpMethod.GET, entity, Prediction.class);

	    assertEquals("500",response.getStatusCode());
		
	}
	

}
