package api.impl;

import api.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello-service-remote")
public interface HelloServiceRemoteApi {
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
