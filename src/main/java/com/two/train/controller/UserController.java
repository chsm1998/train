package com.two.train.controller;


import com.two.train.common.ServerResponse;
import com.two.train.entity.User;
import com.two.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ServerResponse<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public ServerResponse<User> register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/checkUsername")
    public ServerResponse<String> checkUsername(String username) {
        return userService.checkUsername(username);
    }
}

