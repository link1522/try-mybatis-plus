package com.example.mybatis_plus.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.service.UserSerivce;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserSerivce userSerivce;

    @GetMapping("/list")
    public List<User> list () {
        return userSerivce.list();
    }
}
