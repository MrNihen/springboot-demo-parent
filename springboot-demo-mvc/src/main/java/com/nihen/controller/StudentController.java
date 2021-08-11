package com.nihen.controller;

import com.nihen.pojo.PageResult;
import com.nihen.pojo.Result;
import com.nihen.pojo.StatusCode;
import com.nihen.pojo.Student;
import com.nihen.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 学生控制器
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:17
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * //1.查询所有学生
     * @author zhuguanglong
     * @date 2021/8/2 10:50
     * @return com.nihen.pojo.Result
     */
    @GetMapping("/list")
    @ResponseBody
    public Result findAll(){
        try {
            //1.1)找到所有学生
            List<Student> students = studentService.findAll();
            //1.2)返回查询结果
            return new Result(StatusCode.OK,true,"查询学生列表成功！",students);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"查询学生列表失败！");
        }
    }

    /**
     * //2.所有学生+分页
     * @author zhuguanglong
     * @date 2021/8/2 11:13
     * @param page
     * @param pageSize
     * @return com.nihen.pojo.Result
     */
    @GetMapping("/findByPage")
    @ResponseBody
    public Result findByPage(int page,int pageSize){
        try {
            //2.1)找到所有学生
            PageResult<Student> pageResult = studentService.findByPage(page,pageSize);
            //2.2)返回查询结果
            return new Result(StatusCode.OK,true,"分页学生列表成功！",pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"分页学生列表失败！");
        }
    }

    /**
     * 3.搜索学生+分页
     * @author zhuguanglong
     * @date 2021/8/2 12:02
     * @param page
     * @param pageSize
     * @param student
     * @return com.nihen.pojo.Result
     */
    @PostMapping("/search")
    public Result search(int page, int pageSize, @RequestBody Student student){
        try {
            //3.1)分页搜索学生
            PageResult<Student> searchResult = studentService.search(page,pageSize,student);
            //3.2)返回搜索结果
            return new Result(StatusCode.OK,true,"搜索学生成功！",searchResult);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"搜索学生失败！");
        }
    }

    /**
     * 4.添加学生
     * @author zhuguanglong
     * @date 2021/8/2 12:46
     * @param student
     * @return com.nihen.pojo.Result
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Student student){
        try {
            //4.1)添加学生
            studentService.add(student);
            //4.2)返回结果
            return new Result(StatusCode.OK,true,"添加学生成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"添加学生失败！");
        }
    }

    /**
     * 5.修改学生
     * @author zhuguanglong
     * @date 2021/8/2 12:56
     * @param student
     * @return com.nihen.pojo.Result
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Student student){
        try {
            //5.1)修改学生
            studentService.update(student);
            //5.2)返回结果
            return new Result(StatusCode.OK,true,"修改学生成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"修改学生失败！");
        }
    }

    /**
     * 6.删除学生
     * @author zhuguanglong
     * @date 2021/8/2 13:01
     * @param ids
     * @return com.nihen.pojo.Result
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(Integer[] ids){
        try {
            //6.1)删除学生
            studentService.delete(ids);
            //6.2)返回结果
            return new Result(StatusCode.OK,true,"删除学生成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"删除学生失败！");
        }
    }
}
