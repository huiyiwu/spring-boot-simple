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

    /**
     * 使用Post方式请求，RequetBody接收时捕获
     * @param exception
     * @return
     */
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

        Map errResult = new HashMap();
        errResult.put("message",errorInfo.toString());
        errResult.put("code",500);
        return errResult;
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

        Map errResult = new HashMap();
        errResult.put("message",msg);
        errResult.put("code",501);
        return errResult;
    }

    /**
     *使用Post方式，但不用JSON方式提交时捕获
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Map exceptionHandler(BindException e, HttpServletRequest request) {
        String failMsg = e.getBindingResult().getFieldError().getDefaultMessage();
        Map errResult = new HashMap();
        errResult.put("message",failMsg);
        errResult.put("code",502);
        return errResult;
    }

    @ExceptionHandler(Exception.class)
    public Map handleDefaultException(Exception exception) {
        Map errResult = new HashMap();
        errResult.put("message",exception.getMessage());
        errResult.put("code",503);
        return errResult;
    }
}
