package com.two.train.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 对创建时间和修改时间统一操作
 * @program: train
 * @author: chsm
 * @create: 2018-09-04 11:08
 **/
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime localDateTime = nowDateToLocalDateTime();
        metaObject.setValue("gmtCreate", localDateTime);
        metaObject.setValue("gmtModified", localDateTime);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime localDateTime = nowDateToLocalDateTime();
        setFieldValByName("gmtModified", localDateTime, metaObject);
    }

    /**
     * Date转换为LocalDateTime
     * @return LocalDateTime
     */
    private LocalDateTime nowDateToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }
}
