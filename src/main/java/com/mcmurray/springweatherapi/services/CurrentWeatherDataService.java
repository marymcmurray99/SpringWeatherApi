package com.mcmurray.springweatherapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class CurrentWeatherDataService implements WeatherService{
  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Value("${api.current.weather.data}") private String url;
  @Value("${open.weather.map.api.key}") private String apiKey;


  /**
   * Gets the current weather data from the given location from the api at this.url
   * @param zipcode the location we want the weather from (US zip only)
   * @return the weather data
   */
  public String getData(String zipcode) {
    URI requestUrl = new UriTemplate(this.url).expand(zipcode);
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-rapidapi-key", this.apiKey);
    HttpEntity<String> entity = new HttpEntity<>("paramters",headers);
    ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);
    return this.convert(response);
  }

  private String convert(ResponseEntity<String> response) {
    //object mapper will be used here
    return response.toString();
  }

}
