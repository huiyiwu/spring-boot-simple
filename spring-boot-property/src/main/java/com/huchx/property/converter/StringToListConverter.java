package com.huchx.property.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huchx.property.pojo.UserPojo;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@ConfigurationPropertiesBinding
public class StringToListConverter implements Converter<String, List<UserPojo>> {

    @Override
    public List<UserPojo> convert(String json) {
        List<UserPojo> users = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            users = (List<UserPojo>) new ObjectMapper().readValue(json,new TypeReference<List<UserPojo>>(){});
            return  users;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
