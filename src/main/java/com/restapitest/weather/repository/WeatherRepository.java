package com.restapitest.weather.repository;

import com.restapitest.weather.model.WeatherData;

public interface WeatherRepository {
    WeatherData save(WeatherData weatherData);
}