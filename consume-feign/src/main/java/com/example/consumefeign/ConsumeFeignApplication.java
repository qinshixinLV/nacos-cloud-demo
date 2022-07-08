package com.example.consumefeign;

import com.example.consumefeign.loadrule.KonanRuleLoadBalancerClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@LoadBalancerClient(name = "provide-server",configuration = KonanRuleLoadBalancerClientConfiguration.class)
public class ConsumeFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeFeignApplication.class, args);
    }

}
