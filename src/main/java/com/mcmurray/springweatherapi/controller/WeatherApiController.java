package com.mcmurray.springweatherapi.controller;

import com.mcmurray.springweatherapi.services.CurrentWeatherDataService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiController {

  private final CurrentWeatherDataService currentWeatherDataService = new CurrentWeatherDataService();

  @GetMapping("/current-weather-data")
  public String getCurrentWeatherData() {
    return currentWeatherDataService.getCurrentWeatherData("02118").toString();
  }


}
