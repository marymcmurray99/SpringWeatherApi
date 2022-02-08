package com.mcmurray.springweatherapi.controller;

import com.mcmurray.springweatherapi.services.Services;
import com.mcmurray.springweatherapi.services.WeatherService;
import com.mcmurray.springweatherapi.services.WeatherServiceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for weather api calls.
 */
@RestController
public class WeatherApiController {
  private static final ResponseEntity<Object> invalidTokenResponse =
          ResponseHandler.generateResponse("Invalid token.", HttpStatus.UNAUTHORIZED, null);
  @Autowired
  private WeatherServiceFactory weatherServiceFactory;

  /**
   * API call to get current weather data that expects the url format
   * "/current-weather-data/{zipcode}/{token}".
   *
   * @param zipcode  the zip code of the weather data
   * @param tokenVal the bearer token
   * @return API response with weather data or error
   */
  @GetMapping("/current-weather-data/{zipcode}")
  public ResponseEntity<Object> getCurrentWeatherData(@PathVariable("zipcode") String zipcode,
                                                      @RequestHeader("Authorization")
                                                              String tokenVal) {
    Token token = new Token(tokenVal);
    if (!token.isValid()) {
      return invalidTokenResponse;
    }
    WeatherService service =
            this.weatherServiceFactory.getService(Services.CurrentWeatherDataService);
    return ResponseHandler.generateResponse("Data successfully retrieved.", HttpStatus.OK,
            service.getData(zipcode));
  }

  /**
   * API call to get the weather forcast for the next 14 days that expects the format
   * "/weather-forcast/{zipcode}/{token}".
   *
   * @param zipcode  the zipcode for the weather forcast
   * @param tokenVal the bearer token
   * @return API response with weather forcast or error
   */
  @GetMapping("/weather-forcast/{zipcode}")
  public ResponseEntity<Object> getWeatherForcast(@PathVariable("zipcode") String zipcode,
                                                  @RequestHeader("Authorization") String tokenVal) {
    Token token = new Token(tokenVal);
    if (!token.isValid()) {
      return invalidTokenResponse;
    }
    WeatherService service = this.weatherServiceFactory.getService(Services.WeatherForcastService);
    return ResponseHandler.generateResponse("Data successfully retrieved.", HttpStatus.OK,
            service.getData(zipcode));
  }
}
