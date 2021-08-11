package com.nihen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.nihen.mapper")//mapper一定要是tk.mybatis不是spring的mapper,这是个坑，找了很久
public class SpringbootDemoMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoMvcApplication.class, args);
	}

}
