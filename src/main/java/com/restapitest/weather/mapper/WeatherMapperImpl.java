package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.model.WeatherData;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapperImpl implements WeatherMapper {

    @Override
    public WeatherResponseDTO weatherDataToWeatherResponseDTO(WeatherData weatherData) {
        WeatherResponseDTO dto = new WeatherResponseDTO();
        dto.setCityName(weatherData.getName());
        dto.setTemperature(weatherData.getMain().getTemp());
        dto.setCloudiness(weatherData.getClouds().getAll());
        dto.setWeatherDescription(weatherData.getWeather()[0].getDescription());
        dto.setWindSpeed(weatherData.getWind().getSpeed());
        dto.setCountry(weatherData.getSys().getCountry());

        return dto;
    }
}
