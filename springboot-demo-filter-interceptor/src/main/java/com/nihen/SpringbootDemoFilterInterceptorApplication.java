package com.nihen;

import com.nihen.util.MyFilter;
import com.nihen.util.MyFilter02;
import com.nihen.util.MyFilter03;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
@ServletComponentScan  //过滤器注解
public class SpringbootDemoFilterInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoFilterInterceptorApplication.class, args);
    }


//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
//        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
//        registration.setFilter(myFilter());
//        //过滤器名称
//        registration.setName("myFilter");
//
//        //拦截路径
//        registration.addUrlPatterns("/*");
//        //设置顺序
//        registration.setOrder(1);
//        return registration;
//    }
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean02() {
//        FilterRegistrationBean registration2 = new FilterRegistrationBean();
//        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
//        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
//        registration2.setFilter(myFilter02());
//        //过滤器名称
//        registration2.setName("myFilter02");
//        //拦截路径
//        registration2.addUrlPatterns("/*");
//        //设置顺序
//        registration2.setOrder(2);
//        return registration2;
//    }    @Bean
//    public FilterRegistrationBean filterRegistrationBean03() {
//        FilterRegistrationBean registration3 = new FilterRegistrationBean();
//        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
//        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
//        registration3.setFilter(myFilter03());
//        //过滤器名称
//        registration3.setName("myFilter03");
//        //拦截路径
//        registration3.addUrlPatterns("/*");
//        //设置顺序
//        registration3.setOrder(3);
//        return registration3;
//    }
//
//    @Bean
//    public Filter myFilter() {
//        return new MyFilter();
//    }
//
//    @Bean
//    public Filter myFilter02() {
//        return new MyFilter02();
//    }
//    @Bean
//    public Filter myFilter03() {
//        return new MyFilter03();
//    }


//    注册多个时，就注册多个
}
