package com.nacos.code.service;

import api.impl.HelloServiceRemoteApi;
import api.impl.HystrixClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//HystrixClientFallback类必须要实现HystrixClientService
@FeignClient(value = "nacos-hystrix-producer", fallback = HystrixClientFallback.class)
public interface HystrixClientService  {
    @RequestMapping(value = "/hystrix", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}



