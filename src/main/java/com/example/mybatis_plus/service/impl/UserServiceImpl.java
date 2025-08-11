package com.example.mybatis_plus.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;
import com.example.mybatis_plus.service.UserSerivce;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {
}
