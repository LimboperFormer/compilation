package com.lee.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee.mybatisplus.user.entity.User;
import com.lee.mybatisplus.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    public <T> void print(T t) {
        System.out.println(JSON.toJSONString(t));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setAge(18);
        user.setEmail("aaa@qq.com");
        user.setName("张三");
        userMapper.insert(user);
    }

    @Test
    public void deleteById() {
        userMapper.deleteById(10);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("age", "18");
        columnMap.put("email", "aaa@qq.com");
        System.out.println(userMapper.deleteByMap(columnMap));
    }

    @Test
    public void deleteBatchIds() {
        Set<Long> ids = new HashSet<>();
        ids.add(12L);
        ids.add(13L);
        ids.add(14L);
        ids.add(15L);
        userMapper.deleteBatchIds(ids);
    }

    @Test
    public void selectByMap() {
        User user = new User();
        user.setAge(18);
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("age", "18");
        print(userMapper.selectByMap(columnMap));
    }


    @Test
    public void selectOne() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", "Jack") //设置查询编辑。姓名=jack
                .like("email", "@qq.com");   //模糊查询设置    email like "%@qq.com%"
        userMapper.selectOne(userQueryWrapper);
    }
}
