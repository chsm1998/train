package com.two.train.controller;


import com.two.train.common.Const;
import com.two.train.common.ServerResponse;
import com.two.train.entity.Manager;
import com.two.train.entity.User;
import com.two.train.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chsm
 * @since 2018-09-28
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final IManagerService managerService;

    @Autowired
    public ManagerController(IManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/login")
    public ServerResponse<Manager> login(@RequestBody Manager manager, HttpSession session) {
        ServerResponse<Manager> login = managerService.login(manager);
        if (login.isSuccess()) {
            session.setAttribute(Const.MANAGER_LOGIN, login.getData());
        }
        return login;
    }

    @GetMapping("/after/getLogin")
    public ServerResponse<Manager> getLogin(HttpSession session) {
        Manager attribute = (Manager) session.getAttribute(Const.MANAGER_LOGIN);
        if (attribute == null) {
            return ServerResponse.createManagerNeedLogin("未登录");
        }
        return ServerResponse.createSuccessData("获取登录信息成功", attribute);
    }

}

