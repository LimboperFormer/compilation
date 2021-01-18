package com.lee.mybatis;

import com.alibaba.fastjson.JSON;
import com.lee.mybatis.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser() {
        System.out.println(JSON.toJSONString(userMapper.getUser()));
    }

}
