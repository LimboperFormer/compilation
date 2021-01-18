package com.lee.mybatis.user.mapper;

import com.lee.mybatis.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author lee
 * @Date 2021/1/12
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 查询用户信息
     *
     * @return List<User>
     */
//    @Select("select * from user")
    List<User> getUser();

    List<User> getAllUser();
}
