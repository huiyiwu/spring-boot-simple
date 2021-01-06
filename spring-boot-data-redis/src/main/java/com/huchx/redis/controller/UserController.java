package com.huchx.redis.controller;

import com.huchx.redis.pojo.UserPojo;
import com.huchx.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisUtil redisUtil;

    @RequestMapping("insert")
    public String insert(String name,String id,String type){
        if (!StringUtils.isEmpty(type)&&type.equals("0")){
            UserPojo userPojo = new UserPojo(id,name);
            redisUtil.setList("user",userPojo);
        }else {
            ValueOperations<String,String> valueTemplate= stringRedisTemplate.opsForValue();
            valueTemplate.set(id,name);
        }
        return "success";
    }
    @RequestMapping("select")
    public Object select(String key,String type){
        if (!StringUtils.isEmpty(type)&&type.equals("0")){
            return  redisUtil.getList(key,0,-1);
        }else {
            ValueOperations<String,String> valueTemplate = stringRedisTemplate.opsForValue();
            String name = valueTemplate.get(key);
            return name;
        }
    }
}
