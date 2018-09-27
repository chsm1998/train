package com.two.train.service;

import com.two.train.common.ServerResponse;
import com.two.train.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
public interface IUserService extends IService<User> {

    /**
     * 用户注册
     * @param user  用户信息
     * @return  用户信息
     */
    ServerResponse<User> register(User user);

    /**
     * 用户登录
     * @param user  用户信息
     * @return  用户信息
     */
    ServerResponse<User> login(User user);

    /**
     * 校验用户名是否合法
     * @param username  用户名
     * @return  响应信息
     */
    ServerResponse<String> checkUsername(String username);

}
