package com.example.mybatis_plus.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.entity.User;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllByName(String name);

    IPage<User> selectPageByAge(Page<User> page, Integer age);
}
