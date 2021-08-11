package com.nihen.service;

import com.nihen.pojo.Classes;
import com.nihen.pojo.PageResult;

import java.util.List;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:24
 */
public interface ClassesService {

    List<Classes> findAll();

    PageResult<Classes> findByPage(int page, int pageSize);
}
