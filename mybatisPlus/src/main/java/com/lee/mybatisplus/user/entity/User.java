package com.lee.mybatisplus.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author lee
 * @Date 2021/1/12
 * @Version 1.0
 */
@Data
public class User {

    private String name;
    private Integer age;
    private String email;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String isDelete;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}