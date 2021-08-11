package com.nihen.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nihen.mapper.ClassesMapper;
import com.nihen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:52
 */

@Service
public class ClassesService implements com.nihen.service.ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    //1.查询所有班级
    @Override
    public List<Classes> findAll() {
        //1.2)返回所有班级
        return classesMapper.selectAll();
    }

    //2.查询所有班级带分页
    @Override
    public PageResult<Classes> findByPage(int page, int pageSize) {
        //2.1)开始分页查询
        PageHelper.startPage(page,pageSize);
        //2.2)创建要查询的班级实例
        ClassesExample classesExample = new ClassesExample();
        //2.3)开始实例查询
        List<Classes> classesList = classesMapper.selectByExample(classesExample);
        //2.4)将集合转换为分页集合
        Page<Classes> classesPage = (Page<Classes>) classesList;
        //2.4)返回
        return new PageResult<>(classesPage.getTotal(),classesPage.getPages(),classesPage.getResult(),page);
    }




}
