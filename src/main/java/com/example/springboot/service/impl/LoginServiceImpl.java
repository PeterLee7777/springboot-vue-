package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
        User user1 = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user1);
        if (user1 != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                return Result.success(user1);
            }else
                return Result.fail(202,"用户名或密码错误！");
        } else
            return Result.fail(202, "用户名或密码错误！");
    }
}
