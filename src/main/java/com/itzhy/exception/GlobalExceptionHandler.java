package com.itzhy.exception;

import com.itzhy.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception ex)
{
    ex.printStackTrace();
    return Result.error("对不起操作失败");
}

}
