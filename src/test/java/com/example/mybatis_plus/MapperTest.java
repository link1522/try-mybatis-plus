package com.example.mybatis_plus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybatis_plus.entity.Product;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.ProductMapper;
import com.example.mybatis_plus.mapper.UserMapper;

@SpringBootTest
public class MapperTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProductMapper productMapper;

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
        user.setId(5L);
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

    @Test
    void testConcurrentUpdate() {
        Product p1 = productMapper.selectById(1L);
        Product p2 = productMapper.selectById(1L);

        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("用戶 1 修改結果: " + (result1 == 1 ? "成功" : "失敗"));

        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("用戶 2 修改結果: " + (result2 == 1 ? "成功" : "失敗"));
        if (result2 == 0) {
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
            System.out.println("用戶 2 修改重試結果: " + (result2 == 1 ? "成功" : "失敗"));
        }

        Product p3 = productMapper.selectById(1L);
        System.out.println("最後價格: " + p3.getPrice());
    }
}
