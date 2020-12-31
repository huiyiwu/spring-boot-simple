package com.huchx.web.mvc.config;

import com.huchx.web.mvc.bind.MyDateWebBindingInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class MyConfiguration {
    /**
     * 不可与config/ClothColorJsonSerializer配置同时存在
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters(){
//        //创建fastJson转换对象
//        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
//
//        //创建序列化规则
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteNonStringKeyAsString,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullStringAsEmpty);
//
////        中文乱码解决
//        List<MediaType> fastMedisTypes = new ArrayList<>();
//        fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        messageConverter.setSupportedMediaTypes(fastMedisTypes);
//        //将转换规则应用于Converter
//        messageConverter.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters(messageConverter);
//    }

    @Autowired
    public void setWebBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter){
        requestMappingHandlerAdapter.setWebBindingInitializer(new MyDateWebBindingInitializer());
    }
}
