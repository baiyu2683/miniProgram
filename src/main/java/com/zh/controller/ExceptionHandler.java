package com.zh.controller;

import com.zh.common.Result;
import com.zh.common.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 异常处理
 * 可以加入自定义的异常
 * @author zh2683
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result<Object> exception(Exception e) {
        return ResultUtils.success(e.getMessage());
    }
}
