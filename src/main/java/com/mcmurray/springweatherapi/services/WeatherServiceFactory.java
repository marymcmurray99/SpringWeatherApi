package com.mcmurray.springweatherapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceFactory {

  @Autowired
  private CurrentWeatherDataService currentWeatherDataService;
  @Autowired
  private WeatherForcastService weatherForcastService;

  public WeatherService getService(Services serviceType) {
    switch(serviceType) {
      case CurrentWeatherDataService: return currentWeatherDataService;
      case WeatherForcastService: return weatherForcastService;
      default: throw new RuntimeException("The request can not be completed.");
    }
  }

}
