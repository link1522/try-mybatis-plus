package com.example.mybatis_plus.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

// import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
// @TableName(value = "t_user")
public class User {
    // 設定主鍵策略 IdType.ASSIGN_ID => 預設值 (雪花算法)
    // @TableId(type=IdType.ASSIGN_ID)
    private Long id;

    // 直接設定資料庫中的欄位名稱
    // @TableField(value = "username")
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 邏輯刪除 (軟刪除)
    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;
}
