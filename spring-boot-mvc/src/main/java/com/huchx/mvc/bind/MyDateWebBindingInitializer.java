package com.huchx.mvc.bind;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用initBinder处理参数，将参数传给编辑器
 */
public class MyDateWebBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        // date 为2020-12-30时
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
        // date 为时间戳时
        webDataBinder.registerCustomEditor(Date.class,new MyDateEditor());
    }
}
