package com.restapitest.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.restapitest.weather.dto.WeatherData;
import com.restapitest.weather.service.OpenWeatherDataDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.restapitest")
public class WeatherApplication {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(WeatherData.class, new OpenWeatherDataDeserializer());
		objectMapper.registerModule(module);

		SpringApplication.run(WeatherApplication.class, args);
	}

}
