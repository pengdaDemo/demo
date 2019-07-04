package com.nacos.code.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface HystrixClientService {
    @RequestMapping(value = "/hystrix", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
