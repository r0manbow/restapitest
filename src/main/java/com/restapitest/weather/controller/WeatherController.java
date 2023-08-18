package com.restapitest.weather.controller;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.service.WeatherService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public WeatherResponseDTO getWeatherData(@PathVariable String cityName) throws IOException, ParseException {
        return weatherService.getWeatherData(cityName);
    }

}





