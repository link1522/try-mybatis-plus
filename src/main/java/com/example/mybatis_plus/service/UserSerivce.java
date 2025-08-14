package com.example.mybatis_plus.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis_plus.entity.User;

public interface UserSerivce extends IService<User> {
    List<User> listAllByName(String name);
}
