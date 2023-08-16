package com.restapitest.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.weather.dto.OpenWeatherData;
import com.restapitest.weather.dto.WeatherData;
import com.restapitest.weather.dto.WeatherDataCreationException;
import com.restapitest.weather.service.WeatherDataFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class OpenWeatherDataFactory implements WeatherDataFactory {
    @Override
    public WeatherData createWeatherData(String jsonData) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            OpenWeatherData openWeatherData = objectMapper.readValue(jsonData, OpenWeatherData.class);
            return openWeatherData;
        } catch (IOException e) {
            throw new WeatherDataCreationException("Failed to create OpenWeatherData from JSON", e);
        }
    }
}
