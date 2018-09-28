package com.two.train.common;

/**
 * 响应代码枚举类
 * @author chsm
 */
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 警告
     */
    WARN(201, "WARN"),
    /**
     * 错误
     */
    ERROR(500, "ERROR"),
    /**
     * 需要登录
     */
    NEED_LOGIN(300, "NEED_LOGIN"),
    /**
     * 后台需要登录
     */
    MANAGER_NEED_LOGIN(301, "MANAGER_NEED_LOGIN"),
    /**
     * 没有权限
     */
    ILLEGAL_ARGUMENT(400,"ILLEGAL_ARGUMENT"),
    /**
     * 非法操作
     */
    ILLEGAL_OPERATION(401, "ILLEGAL_OPERATION");



    private final int code;

    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
