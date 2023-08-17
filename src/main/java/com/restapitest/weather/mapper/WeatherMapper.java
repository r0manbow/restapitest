package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.model.WeatherData;
import org.mapstruct.Mapper;

@Mapper
public interface WeatherMapper {
    WeatherResponseDTO WeatherData(WeatherData weatherData);
}