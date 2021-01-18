package com.lee.mybatis.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author lee
 * @Date 2021/1/12
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    private String name;
    private Integer age;
    private String email;
    private Long id;
    private String isDelete;
    private Date createTime;
    private Date updateTime;

}