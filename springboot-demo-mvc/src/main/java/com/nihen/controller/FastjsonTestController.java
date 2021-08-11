package com.nihen.controller;

import com.nihen.pojo.Result;
import com.nihen.pojo.StatusCode;
import com.nihen.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/05 10:45
 */
@RestController
public class FastjsonTestController {

    @GetMapping("/fastjson")
    public Result fastjson(){
        //json:{"code":20000,"data":[[],[0,0],"","2021-08-05 11:48:50"],"flag":true,"message":"查询所有成功！"}
        try {
            List<Object> studentList = new ArrayList<>();
            //将List类型的null转成[]
            System.out.println(studentList);
            int[] aa = new int[2];
            System.out.println(aa);
            List<Object> nima = new ArrayList<>();
            nima.add(studentList);
            System.out.println(nima);
            nima.add(aa);
            System.out.println(nima);
            String s = "";
            //将String类型的null转成""
            nima.add(s);
            Date date = new Date();
            nima.add(date);
            System.out.println(nima);
            return new Result(StatusCode.OK,true,"查询所有成功！",nima);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.OK,true,"查询所有成功！");
        }
    }


}
