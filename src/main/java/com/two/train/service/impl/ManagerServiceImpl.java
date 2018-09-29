package com.two.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.two.train.common.MD5Util;
import com.two.train.common.ServerResponse;
import com.two.train.entity.Manager;
import com.two.train.mapper.ManagerMapper;
import com.two.train.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chsm
 * @since 2018-09-28
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Override
    public ServerResponse<Manager> login(Manager manager) {
        Manager manager1 = baseMapper.selectOne(new QueryWrapper<Manager>()
                .eq("username", manager.getUsername())
                .eq("password", MD5Util.encrypt(manager.getPassword())));
        if (manager1 != null) {
            return ServerResponse.createSuccessData("登录成功", manager1.setPassword(null));
        }
        return ServerResponse.createErrorMessage("用户名或密码错误");
    }
}
