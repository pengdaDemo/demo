package com.nacos.code.controller;

import api.impl.HystrixClient;
import com.nacos.code.service.HystrixClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixClientImpl implements HystrixClientService {
    @Value("${server.port}")
    String port;
    @Override
    public String hello(String name) {
                try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "测试断路器"+port;
    }
}
