package com.cloud.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局的Gateway 过滤器
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uname = exchange.getRequest ().getQueryParams ().getFirst ("uname");
        if(uname == null){
            exchange.getResponse ().setStatusCode (HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse ().setComplete ();
        }
        //放行到下一个过滤器
        return chain.filter (exchange);
    }

    /**
     * 过滤器的顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
