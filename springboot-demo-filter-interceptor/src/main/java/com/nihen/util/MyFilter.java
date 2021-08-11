package com.nihen.util;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Description 过滤器演示
 * @Author zhuguanglong
 * @Company 新建一个过滤器需要实现Filter（servlet）接口,并且实现init()、doFilter()、destroy()三个方法。
 * @Date 2021/08/09 13:46
 */

@Order(1) //过滤器顺序注解注解@Order或者接口Ordered的作用是定义Spring IOC容器中Bean的执行顺序的优先级，而不是定义Bean的加载顺序，Bean的加载顺序不受@Order或Ordered接口的影响；
@WebFilter(filterName = "MyFilter",urlPatterns = "/*", //目录下的所有资源进行过滤
        initParams = {@WebInitParam(name = "URL",value = "localhost:8080")}) //初始化参数
public class MyFilter implements Filter {

    private String url;

    /**
     * 过滤器被调用的时候执行，并且只执行一次
     * @author zhuguanglong
     * @date 2021/8/9 13:54
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.url = filterConfig.getInitParameter("URL");
        System.out.println("过滤器1111111被调用了！"+ this.url  );
    }

    /**
     * 过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理
     * @author zhuguanglong
     * @date 2021/8/9 14:06
     * @param request
     * @param response
     * @param chain
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("我是过滤器的执行方法，客户端向Servlet发送的请求被我拦截到了");
        /*  用于过滤器放行（有多个过滤器形成过滤器链的时候放行，放行的顺序在Spring中按照web.xml的<filter-mapping>的顺序执行；
         *  使用注解配置的话，filter的执行顺序跟名称的字母顺序有关，
         *  如果既有在web.xml中声明的Filter，也有通过注解配置的Filter，那么会优先执行web.xml中配置的Filter；
         *  SpringBoot中在过滤器的类上用@Order(1)注解）“1为顺序”
         */
        chain.doFilter(request,response);
        System.out.println("我是过滤器的执行方法，Servlet向客户端发送的响应被我拦截到了");
    }

    /**
     * filter注销调用的方法，跟init（）一样只执行一次
     * @author zhuguanglong
     * @date 2021/8/9 14:19
     */
    @Override
    public void destroy() {
        System.out.println("过滤器11111111111销毁了！臭弟弟再见！");
    }
}
