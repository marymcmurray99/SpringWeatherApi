package com.mcmurray.springweatherapi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file for properties.
 */
@Configuration
@ConfigurationProperties(prefix = "com.mcmurray.springweatherapi")
public class CustomProperties {
  String openWeatherMapApiKey;
  String apiCurrentWeatherData;
  String apiForcast;
}
