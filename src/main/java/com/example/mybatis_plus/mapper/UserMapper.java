package com.example.mybatis_plus.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_plus.entity.User;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllByName(String name);
}
