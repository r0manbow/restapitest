package com.restapitest.weather.mapper;

import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.model.OpenWeatherData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherMapper {
    @Mapping(source = "temperature", target = "main.temp")
    @Mapping(source = "cloudiness", target = "clouds.all")
    @Mapping(source = "weatherDescription", target = "weather[0].description")
    @Mapping(source = "windSpeed", target = "wind.speed")
    @Mapping(source = "country", target = "sys.country")

    default OpenWeatherData weatherResponseDTOToOpenWeatherData(WeatherResponseDTO dto) {
            OpenWeatherData openWeatherData = new OpenWeatherData();

            openWeatherData.setCityName(dto.getName());
            openWeatherData.setTemperature(dto.getMain().getTemp());
            openWeatherData.setCloudiness(dto.getClouds().getAll());
            openWeatherData.setWeatherDescription(dto.getWeather()[0].getDescription());
            openWeatherData.setWindSpeed(dto.getWind().getSpeed());
            openWeatherData.setCountry(dto.getSys().getCountry());

            return openWeatherData;
        }
    }

