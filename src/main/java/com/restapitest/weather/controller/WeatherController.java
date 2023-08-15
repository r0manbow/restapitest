package com.restapitest.weather.controller;

import com.restapitest.weather.dto.OpenWeatherData;
import com.restapitest.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{cityName}")
    public OpenWeatherData getWeatherData (@PathVariable String cityName) throws IOException {
        return (OpenWeatherData) weatherService.getWeatherData(cityName);
    }
}
