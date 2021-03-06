package com.huchx.webservice.service.impl;

import com.huchx.webservice.service.HuchxService;

import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Huchx
 * Date: 2021/3/1 15:51
 */
@WebService(
        name = "HuchxService",//服务名，与接口类中一致
        targetNamespace = "http://webservice.huchx.com",//命名空间
        endpointInterface = "com.huchx.webservice.service.HuchxService"//接口类地址
)
public class HuchxServiceImpl implements HuchxService {
    @Override
    public String sayHello(String name) {
        String formDate = "yyyy-MM-dd HH:mm:ss";
        return "Hello World!"+ name+", Now is "+ new SimpleDateFormat(formDate).format(new Date());
    }
}
