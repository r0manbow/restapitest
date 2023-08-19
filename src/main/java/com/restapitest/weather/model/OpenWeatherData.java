package com.restapitest.weather.model;

import lombok.Data;

@Data
public class OpenWeatherData {
    private String cityName;
    private double temperature;
    private int cloudiness;
    private String weatherDescription;
    private double windSpeed;
    private String country;

}