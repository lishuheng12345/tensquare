package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName BaseExceptionHandle
 * @Author lish
 * @Date 2019/4/11 19:24
 * @description 统一异常处理
 */
@RestControllerAdvice
public class BaseExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result errer(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
