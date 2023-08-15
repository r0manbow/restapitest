package com.restapitest.weather.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface WeatherService<T> {

    T getWeatherData(String cityName) throws IOException;
}
