package com.pokeservice.pokeapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pokemon API")
                        .version("v1.0")
                        .description("API para gerenciamento de Pokémons")
                        .termsOfService("All rigths reserver =)")
                        .contact(new Contact()
                                .name("Support Team")
                                .url("https://www.nonexistente.com/support")
                                .email("support@nothing.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}