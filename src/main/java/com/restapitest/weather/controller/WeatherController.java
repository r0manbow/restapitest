package com.restapitest.weather.controller;

import com.restapitest.weather.dto.WeatherData;
import com.restapitest.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService<WeatherData> weatherService;

    @GetMapping("/{cityName}")
    public WeatherData getWeatherData (@PathVariable String cityName) throws IOException {
        return weatherService.getWeatherData(cityName);

    }
}
