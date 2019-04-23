package com.tensquare.spit.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: BaseExceptionHandle
 * @Author: lish
 * @Date: 2019/4/23 14:32
 * @Description: ${description}
 */
@ControllerAdvice
public class BaseExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result errer(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,"服务器异常");
    }
}
