package com.two.train.config;

import com.two.train.common.Const;
import com.two.train.entity.Manager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 后台管理登录校验
 * @program: shop
 * @author: chsm
 * @create: 2018-09-04 21:28
 **/
public class ManagerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        //
        InterceptorMethod.setResponse(request, response);
        Manager manager = (Manager) session.getAttribute(Const.MANAGER_LOGIN);
        return InterceptorMethod.checkSession(response, manager, true);
    }
}
