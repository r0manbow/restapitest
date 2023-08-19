package com.restapitest.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenWeatherData {
    @JsonProperty("Город")
    private String cityName;

    @JsonProperty("Температура")
    private double temperature;

    @JsonProperty("Облачность")
    private int cloudiness;

    @JsonProperty("Описание погоды")
    private String weatherDescription;

    @JsonProperty("Скорость ветра")
    private double windSpeed;

    @JsonProperty("Страна")
    private String country;
}