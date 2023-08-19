package com.restapitest.weather.repository;

import com.restapitest.weather.mapper.WeatherMapper;
import com.restapitest.weather.model.OpenWeatherData;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {
    private final WeatherMapper weatherMapper;

    public WeatherRepositoryImpl(WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
    }

    @Override
    public OpenWeatherData save(OpenWeatherData openWeatherData) {

        return openWeatherData;
    }
}
