package com.example.consumefeign.loadrule;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class KonanRuleLoadBalancerClientConfiguration {

    // 参数 serviceInstanceListSupplierProvider 会自动注入
    @Bean
    public ReactorServiceInstanceLoadBalancer customLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        //修改这里指向自定义的配置文件
        return new MyLoadBalancerRule(serviceInstanceListSupplierProvider);
    }
}
