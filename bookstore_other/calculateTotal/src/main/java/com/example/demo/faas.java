package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.function.Function;

@Configuration
public class faas {
    @Bean
    public Function<Map<String, Integer>, Integer> calculateTotalPrice() {
        System.out.println("calculatePrice...");
        return book -> book.get("price") * book.get("quantity");
    }
}
