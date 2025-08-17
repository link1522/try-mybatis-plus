package com.example.mybatis_plus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;

@SpringBootTest
public class MapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setName("Mandy");
        user.setAge(22);
        user.setEmail("test6@test.com");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Mandy");
        map.put("age", 22);
        List<User> users1 = userMapper.selectByMap(map);
        users1.forEach(System.out::println);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setAge(36);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    void testDelete() {
        int result = userMapper.deleteById(1956882740187369473L);
        System.out.println(result);
    }

    @Test
    void testSelectAllByName() {
        List<User> users = userMapper.selectAllByName("Jack");
        users.forEach(System.out::println);
    }
}
