package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * Главный класс программы
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main {
    /**
     * Точка входа в программу
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создаем контекст приложения, загружая конфигурацию из файла applicationContext.xml
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Получаем бин (компонент) с именем "refrigeratorController" из контекста
        User user = (User) context.getBean("user");
        user.freeze();
    }
}