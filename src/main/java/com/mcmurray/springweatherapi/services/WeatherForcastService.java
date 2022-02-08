package com.mcmurray.springweatherapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcmurray.springweatherapi.services.model.CurrentWeather;
import com.mcmurray.springweatherapi.services.model.ForcastDay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;

@Service
public class WeatherForcastService implements WeatherService{
  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Value("${api.forcast}") private String url;
  @Value("${rapid.api.key}") private String apiKey;

  /**
   * Gets the 14 day forcast for a zipcode.
   * @param zipcode US zipcode
   * @return the forcast
   */
  @Override
  public ArrayList<ForcastDay> getData(String zipcode) {
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

  private ArrayList<ForcastDay> convert(ResponseEntity<String> response, String zipcode) {
    try {
      // get the response and then get the list of forcasts
      JsonNode root = objectMapper.readTree(response.getBody()).path("response").get(0).path("periods");
      ArrayList<ForcastDay> forcast = new ArrayList<ForcastDay>();
      for (int i = 0; i < 14; i++) {
        forcast.add(new ForcastDay(
                root.get(i).path("minTempF").asDouble(),
                root.path(i).path("maxTempF").asDouble(),
                root.path(i).path("humidity").asDouble(),
                root.path(i).path("windSpeedMPH").asDouble(),
                root.path(i).path("windDir").textValue(),
                root.path(i).path("validTime").textValue(),
                zipcode));
      }
      return forcast;
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error parsing current weather data json", e);
    }
  }
}
