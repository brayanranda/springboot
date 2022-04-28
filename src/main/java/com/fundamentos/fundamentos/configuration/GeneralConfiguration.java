package com.fundamentos.fundamentos.configuration;

import com.fundamentos.fundamentos.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    // Propiedades
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function() {
            return new MyBeanWithPropertiesImplement(name, lastname);
    }
}