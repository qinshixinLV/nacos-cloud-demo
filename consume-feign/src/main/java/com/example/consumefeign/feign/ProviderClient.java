package com.example.consumefeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provide-server")
public interface ProviderClient {
    
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    String echo(@PathVariable(value = "string") String string);
    
}
