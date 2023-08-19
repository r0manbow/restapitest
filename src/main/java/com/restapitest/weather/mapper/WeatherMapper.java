package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.OpenWeatherResponseDTO;
import com.restapitest.weather.model.WeatherData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherMapper {
    @Mapping(source = "main.temp", target = "temperature")
    @Mapping(source = "clouds.all", target = "cloudiness")
    @Mapping(source = "weather", target = "weather")
    @Mapping(source = "wind.speed", target = "windSpeed")
    @Mapping(source = "sys.country", target = "country")
    WeatherData weatherResponseDTOToOpenWeatherData(OpenWeatherResponseDTO dto);
    }

