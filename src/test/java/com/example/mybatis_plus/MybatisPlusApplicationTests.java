package com.example.mybatis_plus;

import java.util.List;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;

@SpringBootTest
class MybatisPlusApplicationTests {
	@Resource
	private UserMapper userMapper;

	@Test
	void testSelectList() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}
}
