package com.mcmurray.springweatherapi.services;

/**
 * Represents a weather service which gets data for specified areas.
 */
@FunctionalInterface
public interface WeatherService {

  /**
   * Gets data about the weather from the given US zipcode.
   * @param zipcode US zipcode
   * @return String of the data
   */
  String getData(String zipcode);
}
