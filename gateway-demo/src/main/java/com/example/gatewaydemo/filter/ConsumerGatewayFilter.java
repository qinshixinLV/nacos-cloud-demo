package com.example.gatewaydemo.filter;

import com.example.gatewaydemo.Response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
public class ConsumerGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getPath().pathWithinApplication().value();
        //获取header中的token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        log.info("进入consumer过滤器:{},methoid:{},token:{}", url, exchange.getRequest().getMethod(), token);
        if (StringUtils.isNotBlank(token)) {
            if (!token.startsWith("101")) {
                return responseFailRs(exchange, new CommonResult(401, "token失效"));
            }
        } else {
            return responseFailRs(exchange, new CommonResult(401, "token未传"));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> responseFailRs(ServerWebExchange exchange, CommonResult resResult) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        byte[] bytes = resResult.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        return serverHttpResponse.writeWith(Flux.just(buffer));
    }
}
