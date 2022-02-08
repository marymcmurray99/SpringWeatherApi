package com.mcmurray.springweatherapi.controller;

import com.mcmurray.springweatherapi.services.Services;
import com.mcmurray.springweatherapi.services.WeatherService;
import com.mcmurray.springweatherapi.services.WeatherServiceFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiController {
  @Autowired
  private WeatherServiceFactory weatherServiceFactory;

  @GetMapping("/current-weather-data")
  public ResponseEntity<Object> getCurrentWeatherData() {
    WeatherService service = this.weatherServiceFactory.getService(Services.CurrentWeatherDataService);
    return ResponseHandler.generateResponse("Data successfully retrieved.", HttpStatus.OK, service.getData("02118"));
  }

  @GetMapping("/weather-forcast")
  public ResponseEntity<Object> getWeatherForcast() {
    WeatherService service = this.weatherServiceFactory.getService(Services.WeatherForcastService);
    return ResponseHandler.generateResponse("Data successfully retrieved.", HttpStatus.OK, service.getData("02118"));
  }




}
