package com.two.train.service;

import com.two.train.common.ServerResponse;
import com.two.train.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chsm
 * @since 2018-09-28
 */
public interface IManagerService extends IService<Manager> {

    /**
     * 管理员登录
     * @param manager   管理员信息   
     * @return  响应信息
     */
    ServerResponse<Manager> login(Manager manager);
    
}
