package com.mcmurray.springweatherapi.services.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents the forcast for a day.
 */
public class ForcastDay implements Serializable {
  private Double minTemp;
  private Double maxTemp;
  private Double humidity;
  private Double windSpeedMPH;
  private String windDirection;
  private String date;
  private Long zipCode;

  public ForcastDay(Double minTemp, Double maxTemp, Double humidity, Double windSpeedMPH, String windDirection, String date, Long zipCode) {
    this.minTemp = minTemp;
    this.maxTemp = maxTemp;
    this.humidity = humidity;
    this.windSpeedMPH = windSpeedMPH;
    this.windDirection = windDirection;
    this.date = date;
    this.zipCode = zipCode;
  }

  public Double getMinTemp() {
    return minTemp;
  }

  public void setMinTemp(Double minTemp) {
    this.minTemp = minTemp;
  }

  public Double getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(Double maxTemp) {
    this.maxTemp = maxTemp;
  }

  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(Double humidity) {
    this.humidity = humidity;
  }

  public Double getWindSpeedMPH() {
    return windSpeedMPH;
  }

  public void setWindSpeedMPH(Double windSpeedMPH) {
    this.windSpeedMPH = windSpeedMPH;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Long getZipCode() {
    return zipCode;
  }

  public void setZipCode(Long zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ForcastDay)) return false;
    ForcastDay that = (ForcastDay) o;
    return minTemp.equals(that.minTemp) && maxTemp.equals(that.maxTemp) && humidity.equals(that.humidity) && windSpeedMPH.equals(that.windSpeedMPH) && windDirection.equals(that.windDirection) && date.equals(that.date) && zipCode.equals(that.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minTemp, maxTemp, humidity, windSpeedMPH, windDirection, date, zipCode);
  }
}
