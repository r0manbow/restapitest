package com.restapitest.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherData {
    public static final String API_KEY = "9dff5cd4775b4839c591b1b3cc727c5d";
    public static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    public static final String LANG_RU = "ru";
    public static final String METRIC = "metric";

    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;

    @Data
    public static class Clouds {
        private int all;
    }

    @Data
    public static class Coord {
        private double lon;
        private double lat;
    }

    @Data
    public static class Main {
        @JsonProperty("feels_like")
        private double feelsLike;
        private double temp;
        private int pressure;
        private int humidity;
        @JsonProperty("temp_min")
        private double tempMin;
        @JsonProperty("temp_max")
        private double tempMax;
        @JsonProperty("sea_level")
        private int seaLevel;
        @JsonProperty("grnd_level")
        private int grndLevel;
    }

    @Data
    public static class Rain {
        @JsonProperty("1h") // Add this annotation
        private double h1;
    }

    @Data
    public static class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;
    }

    @Data
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;
    }

    @Data
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

}
