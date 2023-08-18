package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.model.WeatherData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherMapper {
    @Mapping(source = "main.temp", target = "temperature")
    @Mapping(source = "clouds.all", target = "cloudiness")
    @Mapping(source = "weather[0].description", target = "weatherDescription")
    @Mapping(source = "wind.speed", target = "windSpeed")
    @Mapping(source = "sys.country", target = "country")

    WeatherResponseDTO weatherDataToWeatherResponseDTO(WeatherData weatherData);
}
