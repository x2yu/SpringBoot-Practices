package com.x2yu.demo.controller;

import com.x2yu.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: x2yu
 * @Date: 2019/8/8 19:15
 */

@RestController
public class HelloController {

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setUserName("小明");
        user.setPassWord("xxxx");
        return user;
    }

}
