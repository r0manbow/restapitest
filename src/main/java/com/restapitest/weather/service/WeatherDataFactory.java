package com.restapitest.weather.service;

import com.restapitest.weather.dto.WeatherData;
import org.springframework.stereotype.Service;

@Service
public interface WeatherDataFactory {
    WeatherData createWeatherData(String jsonData);
}
