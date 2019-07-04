package com.nacos.code.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements HystrixClientService{
    @Override
    public String hello(String name) {
        return "熔断成功";
    }
}
