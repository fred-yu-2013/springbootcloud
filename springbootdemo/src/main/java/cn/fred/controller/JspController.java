package cn.fred.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JSP支持，需要
 * 1.引入依赖
 * 2.application.properties里面，配置jsp路径
 */
@Controller
@RequestMapping("/jsp")
public class JspController {
    @RequestMapping("/hi")
    public String sayHello() {
        return "index";
    }
}
