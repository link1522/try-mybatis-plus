package com.example.mybatis_plus;

import java.util.List;
import java.util.Map;

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

    /**
     * Wrapper 進行刪除
     */
    @Test
    void test3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("刪除的數量: " + result);
    }

    /**
     * 查詢名字中包含 n，且 (年齡小於 18 或 email 為空)，將這些資料的年齡改為 30，email 改為 test@example.com
     */
    @Test
    void test4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "n")
                .and(q -> q.lt("age", 30).or().isNull("email"));

        User user = new User();
        user.setAge(18);
        user.setEmail("test@example.com");

        int result = userMapper.update(user, queryWrapper);
        System.out.println("更新了 " + result + " 筆資料");
    }

    /**
     * 查詢名字中包含 n，且 (年齡小於 18 或 email 為空)，將這些資料的年齡改為 30，email 改為 test@example.com
     */
    @Test
    void test5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    /**
     * id 不大於 3 的所有用戶
     * (子查詢 inSql)
     */
    @Test
    void test6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id < 3");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }
}
