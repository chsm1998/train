package com.two.train.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.two.train.common.Const;
import com.two.train.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @program: shop
 * @author: chsm
 * @create: 2018-09-04 21:32
 **/
class InterceptorMethod {
    /**
     * 统一设置响应头与请求编码
     *
     * @param request  请求
     * @param response 响应
     * @throws UnsupportedEncodingException
     */
    static void setResponse(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE, PUT");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");
    }

    /**
     * 校验session是否存在
     *
     * @param response  响应
     * @param manager   用户信息
     * @param isManager 是否为管理员
     * @return 是否存在
     * @throws Exception
     */
    static boolean checkSession(HttpServletResponse response, Object manager, boolean isManager) throws Exception {
        if (manager == null) {
            // 返回未登录状态
            ObjectMapper objectMapper = new ObjectMapper();
            String s = null;
            if (isManager) {
                s = objectMapper.writeValueAsString(ServerResponse.createManagerNeedLogin(Const.NOT_LOGIN));
            } else {
                s = objectMapper.writeValueAsString(ServerResponse.createNeedLogin(Const.NOT_LOGIN));
            }
            response.getWriter().write(s);
            return false;
        }
        return true;
    }

}
