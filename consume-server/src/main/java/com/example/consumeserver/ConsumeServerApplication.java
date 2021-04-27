package com.example.consumeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumeServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConsumeServerApplication.class, args);
    }
    
}
