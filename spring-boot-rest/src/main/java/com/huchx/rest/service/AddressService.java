package com.huchx.rest.service;

import com.huchx.rest.entity.AddressInfo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

/**
 * Author: Huchx
 * Date: 2021/1/22 15:09
 */
@Service
public class AddressService {
    //阿里云获取地址数据接口
    public String url = "http://datavmap-public.oss-cn-hangzhou.aliyuncs.com/areas/csv/100000_province.json";

    private final  RestTemplate restTemplate;

    private final WebClient webClient;


    public AddressService(WebClient.Builder builder,RestTemplateBuilder restTemplateBuilder) {
        this.webClient = builder.baseUrl(url).build();
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<AddressInfo> getByTemplate() {
        Map<String,Object> addressInfos = restTemplate.getForObject(url, Map.class);
        return addressInfos!=null? (List<AddressInfo>) addressInfos.get("rows") :null;
    }

    public List<AddressInfo> getByClient() {
        Map<String,Object> addressInfos = webClient.get().retrieve().bodyToMono(Map.class).block();
        return addressInfos!=null? (List<AddressInfo>) addressInfos.get("rows") :null;
    }
}
