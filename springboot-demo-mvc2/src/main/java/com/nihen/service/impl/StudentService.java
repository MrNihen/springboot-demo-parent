package com.nihen.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nihen.mapper.ClassesMapper;
import com.nihen.mapper.StudentMapper;
import com.nihen.pojo.PageResult;
import com.nihen.pojo.Student;
import com.nihen.pojo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 学生服务逻辑
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:39
 */

@Service
public class StudentService implements com.nihen.service.StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;

    //1.查询所有学生
    @Override
    public List<Student> findAll() {
        //1.1）查询所有学生
        List<Student> students= studentMapper.selectAll();
        //1.2)将学生与班级进行绑定
        for (Student student : students){
            student.setCname(classesMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
        //1.3)打印学生信息
        System.out.println(students);
        //1.4)返回学生列表
        return students;
    }

    //2.分页列表学生
    @Override
    public PageResult<Student> findByPage(int page, int pageSize) {
        //2.1)开始分页
        PageHelper.startPage(page,pageSize);
        //2.2)开始实例查询
        //2.2.1)构造实例查询
        StudentExample studentExample = new StudentExample();
        //2.2.2)开始实例查询
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        //2.3)将学生和班级进行绑定
        for (Student students : studentList){
            students.setCname(classesMapper.selectByPrimaryKey(students.getCid()).getCname());
        }
        //2.4)将学生对象转换成分页对象
        Page<Student> studentPage = (Page<Student>) studentList;
        //2.5)返回结果集
        return new PageResult<>(studentPage.getTotal(),studentPage.getPages(),studentPage.getResult(),page);
    }

    //3.搜索学生+分页
    @Override
    public PageResult<Student> search(int page, int pageSize, Student student) {
        //3.1)开始分页
        PageHelper.startPage(page,pageSize);
        //3.2)开始条件实例查询
        //3.2.1)构建学生实例对象
        StudentExample studentExample = new StudentExample();
        //3.2.2)创建查询对象
        StudentExample.Criteria criteria = studentExample.createCriteria();
        //3.3.3)往查询对象中添加查询条件
        if (StrUtil.isNotBlank(student.getSname())){
            criteria.andSnameLike("%" + student.getSname() + "%");
        }
        if (StrUtil.isNotBlank(student.getAddr())){
            criteria.andAddrLike("%" + student.getAddr() + "%");
        }
        if (student.getCid() != null && student.getCid() != 0){
            criteria.andCidEqualTo(student.getCid());
        }
        //3.3.4)开始进行条件实例查询
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        //3.4)将学生集合和班级进行绑定
        for (Student students : studentList){
            students.setCname(classesMapper.selectByPrimaryKey(students.getCid()).getCname());
        }
        //3.5)将学生对象转换成分页对象
        Page<Student> studentPage = (Page<Student>) studentList;
        //返回分页结果
        return new PageResult<>(studentPage.getTotal(),studentPage.getPages(),studentPage.getResult(),page);
    }

    //4.添加学生
    @Override
    public void add(Student student) {
        //4.1）添加学生
        studentMapper.insert(student);
    }

    //5.修改学生
    @Override
    public void update(Student student) {
        //5.1)修改学生
        studentMapper.updateByPrimaryKey(student);
    }

    //6.删除学生
    @Override
    public void delete(Integer[] ids) {
        //6.1)遍历ids数组
        for (Integer id : ids){
            //6.2)根据ID删除每一个学生对象
            studentMapper.deleteByPrimaryKey(id);
        }
    }


}
