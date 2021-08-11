package com.nihen.util;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import javax.servlet.annotation.WebListener;

/**
 * @Description 监听器
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/09 16:44
 */

@WebListener
public class MyListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("监听器初始化！");


    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("监听器结束！");
    }


}
