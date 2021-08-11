package com.nihen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/07/16 15:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;// 返回码
    private boolean flag;//是否成功
    private String message;//返回信息
    private Object data;// 返回数据
    public Result(Integer code,boolean flag,String message){
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
