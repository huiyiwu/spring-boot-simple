package com.huchx.web.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huchx.web.mvc.pojo.ClothColorPojo;
import com.huchx.web.mvc.pojo.DatePojo;
import com.huchx.web.mvc.pojo.UserPojo;
import javafx.scene.paint.Color;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/user/{id}")
    public String user(@PathVariable long id){
        return "User Id:"+id;
    }
    @RequestMapping("converter")
    public UserPojo converter(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("huchx");
        return userPojo;
    }

    @RequestMapping("serializer")
    public Map<String,Object> jsonSerializer(){
        Map<String,Object> result = new HashMap<>();

        ClothColorPojo clothColorPojo = new ClothColorPojo(Color.ANTIQUEWHITE);
        String colorJson = "{\"color\":\"#f0f8ff\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result.put("serializer",objectMapper.writeValueAsString(clothColorPojo));
            result.put("deserilizer",objectMapper.readValue(colorJson,ClothColorPojo.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
    @RequestMapping("bind")
    public Map<String,Object> bind(Date date){
        Map<String,Object> result = new HashMap<>();
        result.put("pojo",date);
        System.out.println("pojo:"+date.toString());
        return result;
    }
    @RequestMapping("exception")
    public Map<String,Object> exception() throws Exception {
        throw new Exception("发成异常");
    }
}
