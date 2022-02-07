package com.mcmurray.springweatherapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceFactory {

  @Autowired
  private CurrentWeatherDataService currentWeatherDataService;

  public WeatherService getService(Services serviceType) {
    switch(serviceType) {
      case CurrentWeatherDataService: return currentWeatherDataService;
      default: return null;
    }
  }
}
