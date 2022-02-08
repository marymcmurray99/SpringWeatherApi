package com.mcmurray.springweatherapi.services.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class to represent current weather conditions.
 */
public class CurrentWeather {
  private BigDecimal temperature;
  private BigDecimal feelsLike;
  private BigDecimal tempMin;
  private BigDecimal tempMax;
  private Double pressure;
  private Double humidity;
  private Double visibility;
  private BigDecimal windSpeed;
  private String zipcode;


  public CurrentWeather(BigDecimal temperature, BigDecimal feelsLike, BigDecimal tempMin,
                        BigDecimal tempMax, Double pressure, Double humidity, Double visibility,
                        BigDecimal windSpeed, String zipcode) {
    this.temperature = temperature;
    this.feelsLike = feelsLike;
    this.tempMin = tempMin;
    this.tempMax = tempMax;
    this.pressure = pressure;
    this.humidity = humidity;
    this.visibility = visibility;
    this.windSpeed = windSpeed;
    this.zipcode = zipcode;
  }

  public BigDecimal getTemperature() {
    return temperature;
  }

  public void setTemperature(BigDecimal temperature) {
    this.temperature = temperature;
  }

  public BigDecimal getFeelsLike() {
    return feelsLike;
  }

  public void setFeelsLike(BigDecimal feelsLike) {
    this.feelsLike = feelsLike;
  }

  public BigDecimal getTempMin() {
    return tempMin;
  }

  public void setTempMin(BigDecimal tempMin) {
    this.tempMin = tempMin;
  }

  public BigDecimal getTempMax() {
    return tempMax;
  }

  public void setTempMax(BigDecimal tempMax) {
    this.tempMax = tempMax;
  }

  public Double getPressure() {
    return pressure;
  }

  public void setPressure(Double pressure) {
    this.pressure = pressure;
  }

  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(Double humidity) {
    this.humidity = humidity;
  }

  public Double getVisibility() {
    return visibility;
  }

  public void setVisibility(Double visibility) {
    this.visibility = visibility;
  }

  public BigDecimal getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(BigDecimal windSpeed) {
    this.windSpeed = windSpeed;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CurrentWeather)) return false;
    CurrentWeather that = (CurrentWeather) o;
    return temperature.equals(that.temperature) && feelsLike.equals(that.feelsLike)
            && tempMin.equals(that.tempMin) && tempMax.equals(that.tempMax) && pressure.equals(
            that.pressure) && humidity.equals(that.humidity) && visibility.equals(that.visibility)
            && windSpeed.equals(that.windSpeed) && zipcode.equals(that.zipcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, feelsLike, tempMin, tempMax, pressure, humidity, visibility,
            windSpeed, zipcode);
  }
}
