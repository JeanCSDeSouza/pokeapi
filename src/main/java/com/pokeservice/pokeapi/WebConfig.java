package com.pokeservice.pokeapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")  // Permitir todas as origens
                .allowedMethods("GET", "POST", "PATCH", "DELETE", "PUT", "OPTIONS") // Permitir esses métodos
                .allowedHeaders("*");  // Permitir todos os headers
    }
}