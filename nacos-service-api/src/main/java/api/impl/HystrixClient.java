package api.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("hello-service-hystrix")
public interface HystrixClient {
    @GetMapping(value = "/hystrix")
    String hello(@RequestParam("name") String name);
}
