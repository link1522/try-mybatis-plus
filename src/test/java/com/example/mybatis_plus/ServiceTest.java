package com.example.mybatis_plus;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.service.UserSerivce;

@SpringBootTest
public class ServiceTest {
    @Resource
    private UserSerivce userSerivce;

    @Test
    void testCount() {
        int count = userSerivce.count();
        System.out.println(count);
    }

    @Test
    void testSaveBatch() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("哈哈" + i);
            user.setAge(20 + i);
            users.add(user);
        }

        boolean result = userSerivce.saveBatch(users);
        System.out.println("插入是否成功: " + result);
    }

    @Test
    void testListAllByName() {
        List<User> users = userSerivce.listAllByName("Tom");
        users.forEach(System.out::println);
    }
}
