package com.two.train.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 服务响应类
 * @program: shop
 * @author: chsm
 * @create: 2018-08-10 17:21
 **/
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 验证响应状态
     * @return  true/false
     */
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createSuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMessage(String msg) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createSuccessData(String msg, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createWarnData(String msg, T data) {
        return new ServerResponse<>(ResponseCode.WARN.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createNeedLogin(String msg) {
        return new ServerResponse<>(ResponseCode.NEED_LOGIN.getCode(), msg);
    }

    public static <T> ServerResponse<T> createManagerNeedLogin(String msg) {
        return new ServerResponse<>(ResponseCode.MANAGER_NEED_LOGIN.getCode(), msg);
    }

    public static <T> ServerResponse<T> createErrorMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> ServerResponse<T> createIllegalMessage(String msg) {
        return new ServerResponse<>(ResponseCode.ILLEGAL_OPERATION.getCode(), msg);
    }

    /**
     * 对insert操作进行通用处理
     * @param count 成功插入数量
     * @param msg   成功提示消息
     * @param data  成功返回数据
     * @param <T>   成功返回数据类型
     * @return  ServerResponse
     */
    public static <T> ServerResponse<T> checkCount(Integer count, String msg, T data) {
        if (count <= 0) {
            return ServerResponse.createErrorMessage("服务器异常");
        }
        return ServerResponse.createSuccessData(msg, data);
    }
}
