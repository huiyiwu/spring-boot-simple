package com.huchx.property.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@ConfigurationPropertiesBinding
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String json) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
