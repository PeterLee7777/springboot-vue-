package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result Login(@RequestBody User user){
        if(!StringUtils.hasLength(user.getUsername())){
            return Result.fail(201,"登陆失败");
        }
        Result result = loginService.login(user);
        return result;
    }

    @RequestMapping("/register")
    public Result register(@RequestBody User user){
        User findUser = userService.findUserByUsername(user.getUsername());
        if(findUser != null) {
            return Result.fail(103, "用户名已存在！");
        }
        userService.addUser(user);
        return Result.success();
    }
}
