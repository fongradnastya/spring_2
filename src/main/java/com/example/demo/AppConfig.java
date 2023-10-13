package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 * Конфигурационный класс Spring.
 */
@Configuration
@ComponentScan("com.example")
public class AppConfig {

    /**
     * Значение максимальной температуры, получаемое из внешних свойств
     */
    @Value("${maxTemperature}")
    private double maxTemperature;

    /**
     * Значение минимальной температуры, получаемое из внешних свойств
     */
    @Value("${minTemperature}")
    private double minTemperature;

    /**
     * Значение ширины холодильника, получаемое из внешних свойств
     */
    @Value("${width}")
    private double width;

    /**
     * Значение высоты холодильника, получаемое из внешних свойств
     */
    @Value("${height}")
    private double height;

    /**
     * Значение глубины холодильника, получаемое из внешних свойств
     */
    @Value("${depth}")
    private double depth;

    /**
     * Значение типа компрессора, получаемое из внешних свойств
     */
    @Value("${compressorType}")
    private String compressorType;

    /**
     * Определяет бин Refrigerator и внедряет значения из внешних свойств
     * @return Бин Refrigerator
     */
    @Bean
    public TemperatureControl refrigerator() {
        Refrigerator refrigerator = new Refrigerator(maxTemperature, minTemperature);
        refrigerator.setWidth(width);
        refrigerator.setHeight(height);
        refrigerator.setDepth(depth);
        refrigerator.setCompressorType(compressorType);
        return refrigerator;
    }

    /**
     * Определяет бин User, который зависит от бина Refrigerator
     * @return Бин User
     */
    @Bean
    public User user() {
        return new User(refrigerator());
    }
}