package com.skcx.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RabbitMQProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProviderApplication.class, args);
    }
}
