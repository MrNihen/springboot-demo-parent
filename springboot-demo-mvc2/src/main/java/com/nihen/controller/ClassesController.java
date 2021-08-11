package com.nihen.controller;

import com.nihen.pojo.Classes;
import com.nihen.pojo.PageResult;
import com.nihen.pojo.Result;
import com.nihen.pojo.StatusCode;
import com.nihen.service.ClassesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:17
 */
@RestController
@RequestMapping("/classes")
public class ClassesController {

    private static Logger classes_log = LoggerFactory.getLogger(ClassesController.class);

    @Autowired
    private ClassesService classesService;

    /**
     * //1.查询所有班级
     * @author zhuguanglong
     * @date 2021/8/9 20:44
     * @return com.nihen.pojo.Result
     */
    @GetMapping("/list")
    public Result findAll(){

        try {
            //1.1）查询所有班级
            List<Classes> classes = classesService.findAll();
            classes_log.info("查询所有班级成功!"+classes);
            //1.2)返回的结果集
            return new Result(StatusCode.OK,true,"查询所有班级成功！",classes);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,true,"查询所有班级失败！");
        }
    }

    /**
     * //2.查询所有班级带分页
     * @author zhuguanglong
     * @date 2021/8/9 20:59
     * @param page
     * @param pageSize
     * @return com.nihen.pojo.Result
     */
    @PostMapping("/findByPage")
    public Result findByPage(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
        try {
            //2.1）查询所有班级
            PageResult<Classes> pageClasses =classesService.findByPage(page,pageSize);
            classes_log.info("查询所有班级成功!"+pageClasses);
            //2.2)返回的结果集
            return new Result(StatusCode.OK,true,"查询所有班级成功！",pageClasses);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,true,"查询所有班级失败！");
        }
    }

}
