package com.huchx.validated.config;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * Author: Huchx
 * Date: 2021/1/25 9:48
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        StringBuilder errorInfo = new StringBuilder();
        BindingResult bindingResult = exception.getBindingResult();
        for(int i = 0; i < bindingResult.getFieldErrors().size(); i++){
            if(i > 0){
                errorInfo.append(",");
            }
            FieldError fieldError = bindingResult.getFieldErrors().get(i);
            errorInfo.append(fieldError.getField()).append(" :").append(fieldError.getDefaultMessage());
        }

        //返回BaseResponse
        Map response = new HashMap();
        response.put("message",errorInfo.toString());
        response.put("code",500);
        return response;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public Map handleConstraintViolationException(ConstraintViolationException exception) {
        StringBuilder msg = new StringBuilder();
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
            String paramName = pathImpl.getLeafNode().getName();
            String message = constraintViolation.getMessage();
            msg.append("[").append(message).append("]");
        }


        //返回BaseResponse
        Map response = new HashMap();
        response.put("message",msg);
        response.put("code",501);
        return response;
    }
    @ExceptionHandler(BindException.class)
    public Map exceptionHandler(BindException e, HttpServletRequest request) {
        String failMsg = e.getBindingResult().getFieldError().getDefaultMessage();
        Map response = new HashMap();
        response.put("message",failMsg);
        response.put("code",502);
        return response;
    }

    @ExceptionHandler(Exception.class)
    public Map handleDefaultException(Exception exception) {
        Map response = new HashMap();
        response.put("message",exception.getMessage());
        response.put("code",503);
        return response;
    }
}
