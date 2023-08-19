package com.restapitest.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapitest.weather.dto.OpenWeatherResponseDTO;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherData {
    private String cityName;

    private double temperature;

    private int cloudiness;

    private ArrayList<OpenWeatherResponseDTO.Weather> weather;

    private double windSpeed;

    private String country;
}