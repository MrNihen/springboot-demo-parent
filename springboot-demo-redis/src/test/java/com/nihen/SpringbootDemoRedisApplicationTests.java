package com.nihen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootDemoRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void TestSpringBootDataRedis(){
        //1.1)向redis中存放字符串
        redisTemplate.boundValueOps("name").set("张三");
        //1.2)从redis中取得字符串
        String name = (String) redisTemplate.boundValueOps("name").get();
        //1.3)打印
        System.out.println("name = " + name);
//        //1.4)删除
//        redisTemplate.delete("name");
//        //1.5）再取值
//        name = (String) redisTemplate.boundValueOps("name").get();
//        //1.6)再打印
//        System.out.println("name = " + name);
    }

}
