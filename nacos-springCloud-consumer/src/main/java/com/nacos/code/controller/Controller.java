package com.nacos.code.controller;

import api.model.User;
import com.nacos.code.service.HelloBackgroundService;
import com.nacos.code.service.HystrixClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HelloBackgroundService helloBackgroundService;

    @Autowired
    HystrixClientService hystrixClientService;

    @GetMapping(value = "xiaofei")
    public String Xiaofei(@RequestParam("name") String name){
        String callServiceResult = restTemplate.getForEntity("http://nacos-springCloud-producer/hello?name="+name,String.class).getBody();
        System.out.println(callServiceResult);
        return callServiceResult;
    }

    @RequestMapping("/hello")
    public Map<String,Object> hello(){
        Map<String,Object> ret = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        String s1 = helloBackgroundService.hello("张三");
        sb.append(hystrixClientService.hello("测试"));
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = helloBackgroundService.hello(new User("王五", 19));
        sb.append(s3).append("\n");
        ret.put("show",sb.toString());
        return ret;
    }
}
