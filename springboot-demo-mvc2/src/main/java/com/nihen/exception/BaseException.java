package com.nihen.exception;

import com.nihen.controller.ClassesController;
import com.nihen.pojo.Result;
import com.nihen.pojo.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger exception_log = LoggerFactory.getLogger(BaseException.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        exception_log.info("异常："+e.getMessage());
        e.printStackTrace();
        return new Result(StatusCode.ERROR,false,e.getMessage());
    }
}
