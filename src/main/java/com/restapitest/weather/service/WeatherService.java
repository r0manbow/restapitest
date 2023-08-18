package com.restapitest.weather.service;

import com.restapitest.weather.dto.WeatherResponseDTO;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public interface WeatherService {
    WeatherResponseDTO getWeatherData(String cityName) throws IOException, ParseException;

}

