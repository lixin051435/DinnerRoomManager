package com.bysj.drm.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类描述信息 登入拦截器
 *
 * @author linSir
 * @ClassName CheckLoginInterceptor
 * @Description: TODO
 * @date 2018/12/27 15:59
 * @Viersion V1.0.1
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登入
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/loginView");
            System.out.println("CheckLoginInterceptor.preHandle" + "----------------未登入------拦截请求--------------->" + request.getRequestURI());
            return false;
        }
        return true;
    }
}
