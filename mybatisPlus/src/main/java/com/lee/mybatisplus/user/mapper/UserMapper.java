package com.lee.mybatisplus.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.mybatisplus.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author lee
 * @Date 2021/1/12
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
