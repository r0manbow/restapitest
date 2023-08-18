package com.restapitest.weather.dto;

import lombok.Data;

@Data
public class WeatherResponseDTO {
    private String cityName;
    private double temperature;
    private int cloudiness;
    private String weatherDescription;
    private double windSpeed;
    private String country;

}