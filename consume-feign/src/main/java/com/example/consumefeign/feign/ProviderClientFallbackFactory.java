package com.example.consumefeign.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProviderClientFallbackFactory implements FallbackFactory<ProviderClient> {
    @Override
    public ProviderClient create(Throwable throwable) {
        return new ProviderClient() {
            @Override
            public String echo(String string) {
                log.error("echo失败:{}",throwable);
                return null;
            }
        };
    }
}
