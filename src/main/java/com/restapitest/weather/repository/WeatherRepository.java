package com.restapitest.weather.repository;

import com.restapitest.weather.model.OpenWeatherData;

public interface WeatherRepository {
    OpenWeatherData save(OpenWeatherData openWeatherData);
}