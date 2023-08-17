package com.restapitest.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.weather.dto.WeatherResponseDTO;
import com.restapitest.weather.mapper.WeatherMapper;
import com.restapitest.weather.model.WeatherData;
import com.restapitest.weather.repository.WeatherRepository;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, WeatherMapper weatherMapper) {
        this.weatherRepository = weatherRepository;
        this.weatherMapper = weatherMapper;
    }

    @Override
    public WeatherResponseDTO getWeatherData(String cityName) throws IOException, ParseException {
        String url = WeatherData.API_URL
                + "?q="
                + cityName
                + "&lang="
                + WeatherData.LANG_RU
                + "&appid="
                + WeatherData.API_KEY
                + "&units="
                + WeatherData.METRIC;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String jsonResponse = EntityUtils.toString(response.getEntity());

        // Создаем ObjectMapper для парсинга JSON
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(jsonResponse, WeatherData.class);
        weatherRepository.save(weatherData);

        return weatherMapper.WeatherData(weatherData);
    }
}
