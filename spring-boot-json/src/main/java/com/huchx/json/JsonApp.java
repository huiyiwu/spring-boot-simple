package com.huchx.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huchx.json.pojo.AddressPojo;
import com.huchx.json.pojo.UserPojo;
import com.huchx.json.strategy.GsonTransparentStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
public class JsonApp
{

    public static void main( String[] args )
    {
        SpringApplication.run(JsonApp.class,args);
    }
    @RequestMapping("json")
    public Object json(){
        String jsonStr = "[{\"name\":\"huchx\",\"age\":\"1\"},{\"name\":\"huchx2\",\"age\":\"12\"}]";
        Map<String,Object> result = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Jackson
            result.put("jackson",objectMapper.readValue(jsonStr, new TypeReference<List<UserPojo>>(){}));
//
//            //Gson
            Gson gson = new Gson();
            result.put("Gson",gson.fromJson(jsonStr,new TypeToken<List<UserPojo>>(){}.getType()));

            //Gson 使用GsonBuilder添加限制策略
            Gson gson1 = new GsonBuilder().setExclusionStrategies(new GsonTransparentStrategy()).create();
            AddressPojo addressPojo = new AddressPojo("huchx3","15500000000","北京市天安门");
            result.put("GsonStr",gson1.toJson(addressPojo));

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
