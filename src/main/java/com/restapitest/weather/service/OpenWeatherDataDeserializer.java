package com.restapitest.weather.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.weather.dto.OpenWeatherData;

import java.io.IOException;

public class OpenWeatherDataDeserializer extends JsonDeserializer<OpenWeatherData> {

    @Override
    public OpenWeatherData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        JsonNode root = mapper.readTree(jsonParser);

        OpenWeatherData openWeatherData = new OpenWeatherData();

        openWeatherData.setCoord(mapper.readValue(root.get("coord").toString(), OpenWeatherData.Coord.class));
        openWeatherData.setWeather(mapper.readValue(root.get("weather").toString(), OpenWeatherData.Weather[].class));
        openWeatherData.setBase(root.get("base").asText());
        openWeatherData.setMain(mapper.readValue(root.get("main").toString(), OpenWeatherData.Main.class));
        openWeatherData.setVisibility(root.get("visibility").asInt());
        openWeatherData.setWind(mapper.readValue(root.get("wind").toString(), OpenWeatherData.Wind.class));
        openWeatherData.setRain(mapper.readValue(root.get("rain").toString(), OpenWeatherData.Rain.class));
        openWeatherData.setClouds(mapper.readValue(root.get("clouds").toString(), OpenWeatherData.Clouds.class));
        openWeatherData.setDt(root.get("dt").asLong());
        openWeatherData.setSys(mapper.readValue(root.get("sys").toString(), OpenWeatherData.Sys.class));
        openWeatherData.setTimezone(root.get("timezone").asInt());
        openWeatherData.setId(root.get("id").asLong());
        openWeatherData.setName(root.get("name").asText());
        openWeatherData.setCod(root.get("cod").asInt());

        return openWeatherData;
    }
}
