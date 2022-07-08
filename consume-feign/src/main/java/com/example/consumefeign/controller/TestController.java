package com.example.consumefeign.controller;

import com.example.consumefeign.feign.ProviderClient;
import com.example.consumefeign.feign.ProviderClient2;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @Autowired
    private ProviderClient providerClient;

    @Autowired
    private ProviderClient2 providerClient2;
    
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return providerClient.echo(str);
    }

    @RequestMapping(value = "/echo2/{str}", method = RequestMethod.GET)
    public String echo2(@PathVariable String str) {
        return providerClient2.echo(str);
    }

    @RequestMapping(value = "/zero/{num}", method = RequestMethod.GET)
    public String echo(@PathVariable Integer num) {
        return providerClient2.zero(num);
    }
}
