package com.two.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.two.train.common.MD5Util;
import com.two.train.common.ServerResponse;
import com.two.train.common.ServiceCommonMethod;
import com.two.train.entity.User;
import com.two.train.mapper.UserMapper;
import com.two.train.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public ServerResponse<User> register(User user) {
        // 校验用户名是否存在
        boolean bl = isContainerUsername(user.getUsername());
        if (bl) {
            return ServerResponse.createErrorMessage("用户名校验未通过");
        }
        // 对密码进行MD5加密
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        int count = baseMapper.insert(user);
        if (count == 1) {
            // 返回用户信息，对密码和身份证置空
            return ServerResponse.createSuccessData("注册成功", user.setPassword(null).setIdCard(null));
        }
        return ServerResponse.createErrorMessage("注册失败");
    }

    @Override
    public ServerResponse<User> login(User user) {
        // 校验用户名、密码
        User newUser = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("username", user.getUsername())
                .eq("password", MD5Util.encrypt(user.getPassword())));
        if (newUser == null) {
            return ServerResponse.createErrorMessage("登录失败，用户名或密码错误");
        }
        return ServerResponse.createSuccessData("登录成功", newUser.setPassword(null).setIdCard(null));
    }

    @Override
    public ServerResponse<String> checkUsername(String username) {
        if (isContainerUsername(username)) {
            return ServerResponse.createWarnMessage("用户名已被使用");
        }
        return ServerResponse.createSuccessMessage("用户名可用");
    }

    /**
     * 验证用户名是否存在
     * @param username  用户名
     * @return  true：存在，false：不存在
     */
    private boolean isContainerUsername(String username) {
        User user = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("username", username));
        return user != null;
    }


}
