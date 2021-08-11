package com.nihen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/07/18 22:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private long total;     //总记录数
    private long totalPage; //总页数
    private List<T> rows;   //每页的记录集合
    private int page;       //当前页

}
