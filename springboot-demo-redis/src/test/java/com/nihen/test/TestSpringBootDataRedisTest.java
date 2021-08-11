package com.nihen.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestSpringBootDataRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    //1.redis操作字符串
    @Test
    void testStringByRedis() {
        //1.1)向redis中存放字符串
        redisTemplate.boundValueOps("name").set("lisi");
        //1.2)从redis中取得字符串
        String name = (String) redisTemplate.boundValueOps("name").get();
        //1.3)打印
        System.out.println("name = " + name);
        //1.4)删除
        redisTemplate.delete("name");
        //1.5）再取值
        name = (String) redisTemplate.boundValueOps("name").get();
        //1.6)再打印
        System.out.println("name = " + name);
    }

    //2.Redis操作hash
    @Test
    void testHashByRedis() {
        //4.1)向hash中添加内容
        redisTemplate.boundHashOps("studMap").put("sid",1001);
        redisTemplate.boundHashOps("studMap").put("sname","男");
        redisTemplate.boundHashOps("studMap").put("addr","上海");

        //4.2)取出key的集合
        Set keys = redisTemplate.boundHashOps("studMap").keys();
        keys.forEach(key -> {
            System.out.println(key);
        });
        System.out.println("-------------------------------------");

        //4.3)取出value的集合
        List studMap = redisTemplate.boundHashOps("studMap").values();
        studMap.forEach(System.out::println);


    }

    //3.redis操作set
    @Test
    void testSetByRedis() {
        //2.1)向redis中存放set数据
        redisTemplate.boundSetOps("names").add("牛人");
        redisTemplate.boundSetOps("names").add("张飞");
        redisTemplate.boundSetOps("names").add("赵云","关羽","吕布");
        redisTemplate.boundSetOps("names").add("曹操");

        //2.2)从redis中取得set的值
        Set names = redisTemplate.boundSetOps("names").members();
        names.forEach(a->{
            System.out.println(a);
        });
        System.out.println("---------------------------------------");

        //2.3)删除一个值
        redisTemplate.boundSetOps("names").remove("赵云");
        //2.4)再一次得到值
        names = redisTemplate.boundSetOps("names").members();
        //2.5)再一次打印
        names.forEach(System.out::println);
        System.out.println("---------------------------------------");

//        //2.6)删除所有值
//        redisTemplate.delete("names");
//        //2.7)再一次得到值
//        names = redisTemplate.boundSetOps("names").members();
//        //2.8)再一次打印
//        names.forEach(System.out::println);
    }

    //4.redis操作list
    @Test
    void testListByRedis() {
        //3.1)左入栈leftPushAll
        redisTemplate.boundListOps("listnames").rightPushAll("张三","李四","王五");
        //3.2)右入栈rightPushAll
        redisTemplate.boundListOps("listnames").leftPushAll("小明","小红","小马") ;
        //3.3)打印
        List names = redisTemplate.boundListOps("listnames").range(0, -1);
        for (Object name : names) {
            System.out.println(name);
        }
        redisTemplate.delete("listnames");
        System.out.println("-------------------------------------");
        System.out.println(names);
    }
}