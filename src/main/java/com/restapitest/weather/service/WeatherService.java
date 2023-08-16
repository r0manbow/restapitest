package com.restapitest.weather.service;

import com.restapitest.weather.dto.WeatherData;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataFactory dataFactory;

    public WeatherService(WeatherDataFactory dataFactory) {
        this.dataFactory = dataFactory;
    }

    public WeatherData getWeatherData(String apiResponse) {
        return dataFactory.createWeatherData(apiResponse);
    }
}