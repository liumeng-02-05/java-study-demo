package com.example2.demo1.exceptions;

import com.example2.demo1.common.BaseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = Exception.class )
    BaseResult handlerException(Exception e, HttpServletRequest request) {
        return  BaseResult.fail("内部服务器错误");
    }

}

