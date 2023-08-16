package com.restapitest.weather.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
public class WeatherDataWrapper {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "dataType")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = OpenWeatherData.class, name = "OpenWeatherData")
    })
    private WeatherData weatherData;

}