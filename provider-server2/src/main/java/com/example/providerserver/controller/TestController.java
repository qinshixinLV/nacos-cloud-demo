package com.example.providerserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.POST)
    public String echo(@PathVariable String string) {
        log.info("被请求:{}",string);
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello Nacos Discovery " + string;
    }
    
}
