package com.restapitest.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.weather.dto.OpenWeatherResponseDTO;
import com.restapitest.weather.mapper.WeatherMapper;
import com.restapitest.weather.model.WeatherData;
import com.restapitest.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Override
    public WeatherData getWeatherData(String cityName) throws IOException, ParseException {
        String url = OpenWeatherResponseDTO.API_URL
                + "?q="
                + cityName
                + "&lang="
                + OpenWeatherResponseDTO.LANG_RU
                + "&appid="
                + OpenWeatherResponseDTO.API_KEY
                + "&units="
                + OpenWeatherResponseDTO.METRIC;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String jsonResponse = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        OpenWeatherResponseDTO dto = objectMapper.readValue(jsonResponse, OpenWeatherResponseDTO.class);
        WeatherData weatherData = weatherMapper.weatherResponseDTOToOpenWeatherData(dto);
        weatherRepository.save(weatherData);
        return weatherData;
    }

}
