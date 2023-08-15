package com.restapitest.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenWeatherData {

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
