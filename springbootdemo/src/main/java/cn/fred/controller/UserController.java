package cn.fred.controller;

import cn.fred.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello2")
    public Object sayHello() {
        log.info("enter /hello2");
        return "hello";
    }

    /**
     * localhost:8080/register?username=deer&passwd=123
     * @param username
     * @param passwd
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String passwd) {
        log.info("enter login ...");
        boolean login = userService.login(username, passwd);
        if(login) {
            return "登陆成功";
        }else {
            return  "登陆失败";
        }
    }

    /**
     * localhost:8080/login?username=deer&passwd=123
     * @param username
     * @param passwd
     * @return
     */
    @RequestMapping("/register")
    public String register(String username,String passwd) {
        boolean login = userService.register(username, passwd);
        if(login) {
            return "注册成功";
        }else {
            return  "注册失败";
        }
    }

    /**
     * localhost:8080/batchAdd?username=enjoy&passwd=123
     * @param username
     * @param passwd
     * @return
     */
    @RequestMapping("/batchAdd")
    public String batchAdd(String username,String passwd) {
        userService.batchAdd(username, passwd);
        return "成功";
    }

}
