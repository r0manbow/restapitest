package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.model.OpenWeatherData;
import org.springframework.stereotype.Component;

@Component
public  class WeatherMapperImpl implements WeatherMapper {

    @Override
    public OpenWeatherData weatherResponseDTOToOpenWeatherData(WeatherResponseDTO dto) {
        OpenWeatherData openWeatherData = new OpenWeatherData();

        openWeatherData.setCityName(dto.getName());
        openWeatherData.setTemperature(dto.getMain().getTemp());
        openWeatherData.setCloudiness(dto.getClouds().getAll());
        openWeatherData.setWeatherDescription(dto.getWeather()[0].getDescription());
        openWeatherData.setWindSpeed(dto.getWind().getSpeed());
        openWeatherData.setCountry(dto.getSys().getCountry());

        return openWeatherData;
    }
}
