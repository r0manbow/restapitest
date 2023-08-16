package com.restapitest.weather.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.restapitest.weather.constant.OpenWeatherConstant;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.weather.dto.OpenWeatherData;
import com.restapitest.weather.dto.WeatherData;
import com.restapitest.weather.dto.WeatherDataWrapper;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class OpenWeatherService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherDataWrapper getWeatherData(String cityName) throws IOException, ParseException {
        String url = OpenWeatherConstant.API_URL
                + "?q="
                + cityName
                + "&lang="
                + OpenWeatherConstant.LANG_RU
                + "&appid="
                + OpenWeatherConstant.API_KEY
                + "&units="
                + OpenWeatherConstant.METRIC;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String jsonResponse = EntityUtils.toString(response.getEntity());

        WeatherData weatherData = objectMapper.readValue(jsonResponse, OpenWeatherData.class);

        WeatherDataWrapper wrapper = new WeatherDataWrapper();
        wrapper.setWeatherData(weatherData);
        return wrapper;
        }
    }

