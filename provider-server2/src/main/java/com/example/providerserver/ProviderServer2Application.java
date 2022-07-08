package com.example.providerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderServer2Application {
    
    public static void main(String[] args) {
        SpringApplication.run(ProviderServer2Application.class, args);
    }
    
}
