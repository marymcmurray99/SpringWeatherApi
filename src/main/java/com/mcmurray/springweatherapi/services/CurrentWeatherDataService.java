package com.mcmurray.springweatherapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcmurray.springweatherapi.services.model.CurrentWeather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class CurrentWeatherDataService implements WeatherService{
  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Value("${api.current.weather.data}") private String url;
  @Value("${rapid.api.key}") private String apiKey;


  /**
   * Gets the current weather data from the given location from the api at this.url
   * @param zipcode the location we want the weather from (US zip only)
   * @return the weather data
   */
  @Override
  public CurrentWeather getData(String zipcode) {
    ResponseEntity<String> response = this.callWeatherApi(zipcode);
    return this.convert(response, zipcode);
  }

  private ResponseEntity<String> callWeatherApi(String zipcode) {
    URI requestUrl = new UriTemplate(this.url).expand(zipcode);
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-rapidapi-key", this.apiKey);
    HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
    return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);
  }

  private CurrentWeather convert(ResponseEntity<String> response, String zipcode) {
    try {
      JsonNode root = objectMapper.readTree(response.getBody());
      return new CurrentWeather(BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                      BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()),
                      BigDecimal.valueOf(root.path("main").path("temp_min").asDouble()),
                      BigDecimal.valueOf(root.path("main").path("temp_max").asDouble()),
                      root.path("main").path("pressure").asDouble(),
                      root.path("main").path("humidity").asDouble(),
                      root.path("visibility").asDouble(),
                      BigDecimal.valueOf(root.path("wind").path("speed").asDouble()),
                      zipcode);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error parsing current weather data json", e);
    }
  }

}
