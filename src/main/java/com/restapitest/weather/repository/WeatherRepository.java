package com.restapitest.weather.repository;

import com.restapitest.weather.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
    // Дополнительные методы для работы с данными о погоде
}