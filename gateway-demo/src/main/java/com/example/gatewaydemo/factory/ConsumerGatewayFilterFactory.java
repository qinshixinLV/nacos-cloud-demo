package com.example.gatewaydemo.factory;

import com.example.gatewaydemo.filter.ConsumerGatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsumerGatewayFilterFactory extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return new ConsumerGatewayFilter();
    }
}
