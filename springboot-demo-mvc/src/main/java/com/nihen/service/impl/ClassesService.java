package com.nihen.service.impl;


import com.nihen.mapper.ClassesMapper;
import com.nihen.pojo.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 班级逻辑服务
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
}
