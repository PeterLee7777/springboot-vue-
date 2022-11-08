package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.User;

public interface UserService {
    User findUserByUsername(String username);

    void addUser(User user);

    Page<User> listUser(Integer pageNum, Integer pageSize, String search);

    void updateUserById(User user);

    void deleteUserById(Integer id);
}
