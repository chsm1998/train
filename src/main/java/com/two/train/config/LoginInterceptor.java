package com.two.train.config;

import com.two.train.common.Const;
import com.two.train.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器，对前台登录状态做统一处理，使controller获取时必定存在user对象
 * @program: pokemon
 * @author: chsm
 * @create: 2018-08-17 10:52
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        InterceptorMethod.setResponse(request, response);
        User user = (User) session.getAttribute(Const.LOGIN_USER);
        return InterceptorMethod.checkSession(response, user, false);
    }
}
