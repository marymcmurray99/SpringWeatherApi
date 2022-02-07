package com.mcmurray.springweatherapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class CurrentWeatherDataService {
  @Value("${api.current.weather.data}")
  private static String CURRENT_WEATHER_DATA_URL;
  @Value("${api.key}")
  private String apiKey;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper objectMapper = new ObjectMapper();

  public ResponseEntity<String> getCurrentWeatherData(String zipcode) {
    URI url = new UriTemplate(CURRENT_WEATHER_DATA_URL).expand(zipcode, apiKey);
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    return response;
  }



}
