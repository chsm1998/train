package com.two.train.controller;


import com.two.train.common.Const;
import com.two.train.common.ServerResponse;
import com.two.train.entity.User;
import com.two.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ServerResponse<User> login(@RequestBody User user, HttpSession session) {
        ServerResponse<User> login = userService.login(user);
        if (login.isSuccess()) {
            session.setAttribute(Const.LOGIN_USER, login.getData());
        }
        return login;
    }

    @PutMapping("/register")
    public ServerResponse<User> register(@RequestBody User user, HttpSession session) {
        ServerResponse<User> register = userService.register(user);
        if (register.isSuccess()) {
            session.setAttribute(Const.LOGIN_USER, register.getData());
        }
        return register;
    }

    @GetMapping("/checkUsername")
    public ServerResponse<String> checkUsername(String username) {
        return userService.checkUsername(username);
    }

    @GetMapping("/getLoginUser")
    public ServerResponse<User> getLoginUser(HttpSession session) {
        User user = (User) session.getAttribute(Const.LOGIN_USER);
        if (user != null) {
            return ServerResponse.createSuccessData("获取登录信息成功", user);
        }
        return ServerResponse.createWarnMessage("用户未登录");
    }

    @GetMapping("/exitLogin")
    public ServerResponse<String> exitLogin(HttpSession session) {
        User user = (User) session.getAttribute(Const.LOGIN_USER);
        if (user != null) {
            session.removeAttribute(Const.LOGIN_USER);
            return ServerResponse.createSuccessMessage("退出登录成功");
        }
        return ServerResponse.createIllegalMessage("非法操作");
    }

}

