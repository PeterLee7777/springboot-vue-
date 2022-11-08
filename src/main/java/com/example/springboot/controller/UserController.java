package com.example.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result save(@RequestBody User user){
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        userService.addUser(user);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody User user){
        userService.updateUserById(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){
        System.out.println(id);
        userService.deleteUserById(id);
        return Result.success();
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam(defaultValue = "") String search){
        Page<User> userPage = userService.listUser(pageNum, pageSize, search);
        return Result.success(userPage);
    }

}
