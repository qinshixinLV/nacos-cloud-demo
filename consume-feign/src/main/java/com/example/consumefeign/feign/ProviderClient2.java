package com.example.consumefeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provide-server2",fallbackFactory = ProviderClient2FallbackFactory.class)
public interface ProviderClient2 {
    
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.POST)
    String echo(@PathVariable(value = "string") String string);

    @RequestMapping(value = "/zero/{num}", method = RequestMethod.GET)
    String zero(@PathVariable(value = "num") Integer  num);
}
