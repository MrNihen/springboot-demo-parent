package com.nihen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/09 14:24
 */

@RestController
public class FilterTestController {

    @PostMapping("/filter")
    public void filterTest() throws Exception{
        System.out.println("我是控制类里面的方法，我正在被执行...............");
    }
}
