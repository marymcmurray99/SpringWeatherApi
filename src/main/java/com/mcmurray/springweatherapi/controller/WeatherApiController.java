package com.mcmurray.springweatherapi.controller;

import com.mcmurray.springweatherapi.services.CurrentWeatherDataService;
import com.mcmurray.springweatherapi.services.Services;
import com.mcmurray.springweatherapi.services.WeatherService;
import com.mcmurray.springweatherapi.services.WeatherServiceFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiController {

  @Value("${api.current.weather.data}") private String CURRENT_WEATHER_DATA_URL;
  @Value("${open.weather.map.api.key}") private String OPEN_WEATHER_MAP_API_KEY;

  @Autowired
  private WeatherServiceFactory weatherServiceFactory;

  @GetMapping("/current-weather-data")
  public String getCurrentWeatherData() {
    WeatherService service = this.weatherServiceFactory.getService(Services.CurrentWeatherDataService);
    return service.getData("02118");
  }


}
