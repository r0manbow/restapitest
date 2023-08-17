package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.model.WeatherData;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapperImpl implements WeatherMapper {
    @Override
    public WeatherResponseDTO WeatherData(WeatherData weatherData) {
        return null;
    }
}
