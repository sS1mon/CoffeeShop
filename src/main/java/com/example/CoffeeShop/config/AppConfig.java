package com.example.CoffeeShop.config;

import com.example.CoffeeShop.repository.OrderRepository;
import com.example.CoffeeShop.repository.OrderRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepositoryImpl();
    }
}
