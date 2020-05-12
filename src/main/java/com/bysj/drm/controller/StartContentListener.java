package com.bysj.drm.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartContentListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("StartContentListener.contextInitialized------初始化成功--------");
       
        ServletContext servletContext = servletContextEvent.getServletContext();
        //获取上下文
        String contextPath = servletContext.getContextPath();
        //共享到全局全局上下文路径
        servletContext.setAttribute("APP_CONTEXT", contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //监听器销毁操作...
    }
}
