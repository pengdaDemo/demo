package com.nacos.code.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "gethello")
    public String hello(String name) {
        //do stuff that might fail
        return "qqqqqqqqqqqq";
    }

    //原服务被阻止时，会被调用的替代方法，参数和返回值类型需要与原方法一致
    public String gethello(String name) {
        return "xshcgebhg";
    }
}

