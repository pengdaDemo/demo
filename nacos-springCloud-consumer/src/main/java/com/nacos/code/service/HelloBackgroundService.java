package com.nacos.code.service;

import api.impl.HelloServiceRemoteApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@FeignClient(value = "nacos-springCloud-producer")
public interface HelloBackgroundService extends HelloServiceRemoteApi {

}
