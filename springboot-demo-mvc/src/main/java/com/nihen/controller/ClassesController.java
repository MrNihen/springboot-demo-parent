package com.nihen.controller;

import com.nihen.pojo.Classes;
import com.nihen.pojo.Result;
import com.nihen.pojo.StatusCode;

import com.nihen.pojo.Student;
import com.nihen.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 班级控制器
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:17
 */
@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    //1.查询所有班级
    @GetMapping("/list")
    public Result findAll(){
        try {
            //1.1）查询所有班级
            List<Classes> classes = classesService.findAll();
            //1.2)返回的结果集
            return new Result(StatusCode.OK,true,"查询所有班级成功！",classes);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"查询所有班级失败！");
        }
    }

}
