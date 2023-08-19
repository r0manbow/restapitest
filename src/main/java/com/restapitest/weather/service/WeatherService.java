package com.restapitest.weather.service;

import com.restapitest.weather.model.OpenWeatherData;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public interface WeatherService {
    OpenWeatherData getWeatherData(String cityName) throws IOException, ParseException;

}