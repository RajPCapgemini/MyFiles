package com.cg.bankapp.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("**************************************************************************");
        log.info("Path of the Request Received -----> " + exchange.getRequest().getPath());
        log.info("Request -----> " + exchange.getRequest().getBody().toString());
        log.info("Ip Address Of Requester -----> " + exchange.getRequest().getLocalAddress().getAddress());
        log.info("Port Of Requester -----> " + exchange.getRequest().getLocalAddress().getPort());
        log.info("**************************************************************************");

        return chain.filter(exchange);
    }

}