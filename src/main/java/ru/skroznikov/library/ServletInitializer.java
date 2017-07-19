package ru.skroznikov.library;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.skroznikov.library"}) //указываем, с какого пакета начинаем искать спринг-бины
public class ServletInitializer extends SpringBootServletInitializer {



}
