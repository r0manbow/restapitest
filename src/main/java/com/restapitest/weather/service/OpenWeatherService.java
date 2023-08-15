package com.restapitest.weather.service;

import com.restapitest.weather.constant.OpenWeatherConstant;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.weather.dto.OpenWeatherData;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class OpenWeatherService implements WeatherService <OpenWeatherData>{
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public OpenWeatherData getWeatherData(String cityName) throws IOException, ParseException {
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

        try {
            return objectMapper.readValue(jsonResponse, OpenWeatherData.class);
        } catch (JsonMappingException e) {
            throw new IOException("Failed to map JSON response to WeatherData", e);
        }
    }
}
