package com.hdw.controller;

import com.hdw.util.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: evils
 * CreateDate:  2019/3/8
 *
 * @author houdengw
 * @version 1.0
 */
@ControllerAdvice
public class AppErrorController {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public  ApiResponse ErrorHandler(HttpServletRequest request,HttpServletResponse response,Exception e){

        if(e instanceof org.springframework.web.servlet.NoHandlerFoundException){

            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }else{
            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
        }

    }

}