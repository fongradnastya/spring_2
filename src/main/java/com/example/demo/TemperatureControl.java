package com.example.demo;

/**
 * Интерфейс контроллера темрературы
 */
public interface TemperatureControl {
    /**
     * Включает контроллер
     */
    void turnOn();

    /**
     * Выключает контроллер
     */
    void turnOff();

    /**
     * Задаёт нужную температуру
     * @param temperature температура в градусах цельсия
     */
    void setTemperature(double temperature);

    /**
     * Получает текущую температуру
     * @return температура в градусах цельсия
     */
    double getTemperature();
}
