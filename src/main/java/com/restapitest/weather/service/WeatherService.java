package com.restapitest.weather.service;

import com.restapitest.weather.model.WeatherData;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public interface WeatherService {
    WeatherData getWeatherData(String cityName) throws IOException, ParseException;

}