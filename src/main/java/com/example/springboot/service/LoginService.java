package com.example.springboot.service;

import com.example.springboot.common.Result;
import com.example.springboot.entity.User;

public interface LoginService {
    Result login(User user);
}
