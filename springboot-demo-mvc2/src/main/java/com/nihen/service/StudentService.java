package com.nihen.service;

import com.nihen.pojo.PageResult;
import com.nihen.pojo.Student;

import java.util.List;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:20
 */
public interface StudentService {
    List<Student> findAll();

    PageResult<Student> findByPage(int page, int pageSize);

    PageResult<Student> search(int page, int pageSize, Student student);

    void add(Student student);

    void update(Student student);

    void delete(Integer[] ids);
}
