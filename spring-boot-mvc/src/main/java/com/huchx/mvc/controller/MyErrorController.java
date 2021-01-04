package com.huchx.mvc.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 使用此方式自定义错误时，需注释掉MyErrorAttribute
 */
@Controller
public class MyErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    };

    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    @ResponseBody
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response){
        ServletWebRequest requestAttributes =  new ServletWebRequest(request);
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        attr.put("code","-2");
        attr.put("message","浏览器访问时发生异常");
        return JSONObject.toJSONString(attr);
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Map<String, Object> errorApiHandler(HttpServletRequest request){
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        Map<String, Object> attr=this.errorAttributes.getErrorAttributes(requestAttributes, false);
        attr.put("code","-2");
        attr.put("message","Postman访问时发生异常");
        return attr;
    }
}
