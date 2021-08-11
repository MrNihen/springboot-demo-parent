package com.nihen.exception;

import com.nihen.pojo.Result;
import com.nihen.pojo.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 全局异常处理类
 * @Author zhuguanglong
 * @Company
 * @Date 2021/03/30 14:50
 */
@ControllerAdvice
public class BaseException {
    /**
     * 1.处理其他异常，直接返回错误信息
     * @author zhuguanglong
     * @date 2021/8/5 13:12
     * @param e
     * @return com.nihen.pojo.Result
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(StatusCode.ERROR,false,e.getMessage());
    }
}
