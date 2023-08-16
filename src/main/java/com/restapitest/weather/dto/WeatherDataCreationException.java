package com.restapitest.weather.dto;

public class WeatherDataCreationException extends RuntimeException{
    public WeatherDataCreationException(String message, Throwable cause) {
        super (message, cause);
    }
}
