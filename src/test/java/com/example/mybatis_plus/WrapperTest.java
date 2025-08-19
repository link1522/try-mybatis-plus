package com.example.mybatis_plus;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;

@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;

    /**
     * 查詢名字中包含 M，年齡大於 10 且小於 25，email 不為空的用戶
     */
    @Test
    void test1() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
            .like("name", "M")
            .ge("age", 10)
            .le("age", 25)
            .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 按年齡降序查詢用戶，如果年齡相同就按 id 升序
     */
    @Test
    void test2() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }
}
