package com.nihen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.nihen.mapper")
public class SpringbootDemoMvc2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoMvc2Application.class, args);
    }

}
