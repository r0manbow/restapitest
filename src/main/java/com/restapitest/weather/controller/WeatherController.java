package com.restapitest.weather.controller;

import com.restapitest.weather.dto.WeatherData;
import com.restapitest.weather.dto.WeatherDataWrapper;
import com.restapitest.weather.service.OpenWeatherService;
import com.restapitest.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final OpenWeatherService openWeatherService;

    @Autowired
    public WeatherController(WeatherService weatherService, OpenWeatherService openWeatherService) {
        this.weatherService = weatherService;
        this.openWeatherService = openWeatherService;
    }

    @GetMapping("/{cityName}")
    public WeatherDataWrapper getWeatherData (@PathVariable String cityName) throws IOException {
        return openWeatherService.getWeatherData(cityName);
    }
}
