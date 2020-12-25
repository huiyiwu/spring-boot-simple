package com.huchx.property.controller;

import com.huchx.property.config.HuchxProperty;
import com.huchx.property.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Index {
    @Autowired
    HuchxProperty huchxProperty;
    @Value("${name}")
    String name;
    @Value("${random}")
    int randomValue;


    /**
     * 测试属性映射类
     * @return
     */
    @RequestMapping("test1")
    public Object index(){
        return  huchxProperty;
    }

    /**
     * 测试YAML属性引用
     * @return
     */
    @RequestMapping("test2")
    public String test2(){
        return "name："+name+";随机值为:"+randomValue;
    }

    /**
     * 时间转换
     * 测试自定义转换器Converter
     * @return
     */
    @RequestMapping("test3")
    public String test3(Date date){
        return  "date:"+date.getTime();
    }
    /**
     * 集合转换器
     * 测试自定义转换器Converter
     * @return
     * 测试参数 users:[{"name":"huchx","age":1},{"name":"huchx2","age":1}]
     */
    @RequestMapping("test4")
    public List<UserPojo> test4(@RequestParam List<UserPojo> users){
        return  users;
    }

    @RequestMapping("testPost")
    public Map<String, Object> testPost(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("name","success");
        return resultMap;
    }
}
