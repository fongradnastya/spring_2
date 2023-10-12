package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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
     * Значение процессора, получаемое из внешних свойств.
     */
    @Value("${maxTemperature}")
    private double maxTemperature;

    /**
     * Значение оперативной памяти, получаемое из внешних свойств.
     */
    @Value("${minTemperature}")
    private double minTemperature;

    /**
     * Значение видеокарты, получаемое из внешних свойств.
     */
    @Value("${width}")
    private double width;

    /**
     * Значение жесткого диска, получаемое из внешних свойств.
     */
    @Value("${height}")
    private double height;

    @Value("${depth}")
    private double depth;

    @Value("${compressorType}")
    private String compressorType;

    /**
     * Определяет бин PersonalComputer и внедряет значения из внешних свойств.
     *
     * @return Бин PersonalComputer
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
     * Определяет бин User, который зависит от бина PersonalComputer.
     *
     * @return Бин User
     */
    @Bean
    public User user() {
        return new User(refrigerator());
    }
}