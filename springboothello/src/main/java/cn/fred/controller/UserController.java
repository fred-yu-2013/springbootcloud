package cn.fred.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/hi")
    public Object sayHi() {
        return  "hi enjoy";
    }
}
