package com.example.mybatis_plus.service.impl;

import java.util.List;

// import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;
import com.example.mybatis_plus.service.UserSerivce;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {

    // 可以自己引入 userMapper 或者透過 baseMapper 直接使用
    // @Resource
    // private UserMapper userMapper;

    @Override
    public List<User> listAllByName(String name) {
        // return userMapper.selectAllByName(name);
        return baseMapper.selectAllByName(name);
    }
}
