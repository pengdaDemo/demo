package com.nacos.code.controller;

import api.impl.HelloServiceRemoteApi;
import api.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class HelloServiceRemoteApiImpl implements HelloServiceRemoteApi {
    @Value("${server.port}")
    String port;

    @Override
    public String hello(@RequestParam("name") String name) {
//        try {
//            Thread.sleep(10000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "hello  "+port+"    "+name;
    }

    @Override
    public User hello(String name, Integer age) {
        try {
            name= URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        if (user == null) {
            return "未知";
        }
        return user.toString();
    }
}
