package com.example.mybatis_plus.handler;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert 填充 datetime");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 只有在欄位沒有給值時才執行
        Object age = this.getFieldValByName("age", metaObject);
        if (age == null) {
            this.strictInsertFill(metaObject, "age", Integer.class, 16);
        }

        // 只針對有特定欄位的表
        boolean hasAuthor = metaObject.hasSetter("author");
        if (hasAuthor) {
            this.strictInsertFill(metaObject, "author", String.class, "default");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update 填充 datetime");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
