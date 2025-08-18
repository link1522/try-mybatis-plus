package com.example.mybatis_plus;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;

@SpringBootTest
public class InterceptorTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void testSelectPage() {
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPage(page, null);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
        
        long total = page.getTotal();
        System.out.println("總共: " + total + " 筆");
        boolean hasNext = page.hasNext();
        System.out.println("有下一頁? " + hasNext);
        boolean hasPrev = page.hasPrevious();
        System.out.println("有上一頁? " + hasPrev);
    }
}
