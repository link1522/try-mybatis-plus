package com.example.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

// import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
// @TableName(value = "t_user")
public class User {
    // 設定主鍵策略 IdType.ASSIGN_ID => 預設值 (雪花算法)
    @TableId(type=IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
