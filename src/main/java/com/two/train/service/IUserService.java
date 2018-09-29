package com.two.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.two.train.common.ServerResponse;
import com.two.train.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.two.train.vo.UserVo;

import java.util.List;

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

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return  用户信息
     */
    ServerResponse<List<User>> queryByUsername(String username);

    /**
     * 分页查询
     * @param userVo    用户视图对象
     * @return  用户信息
     */
    ServerResponse<IPage> queryPage(UserVo userVo);

}
