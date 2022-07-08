package com.example.consumefeign.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProviderClient2FallbackFactory implements FallbackFactory<ProviderClient2> {
    @Override
    public ProviderClient2 create(Throwable throwable) {
        return new ProviderClient2() {
            @Override
            public String echo(String string) {
                log.error("echo失败:{}",throwable);
                return null;
            }

            @Override
            public String zero(Integer num) {
                log.error("zero失败:{}",throwable);
                return null;
            }
        };
    }
}
