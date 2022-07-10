package com.example.gatewaydemo.config;

import com.example.gatewaydemo.ratelimit.IpKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimitConfig {

    @Bean(name = "ipKeyResolver")
    public KeyResolver userIpKeyResolver() {
        return new IpKeyResolver();
    }
}
