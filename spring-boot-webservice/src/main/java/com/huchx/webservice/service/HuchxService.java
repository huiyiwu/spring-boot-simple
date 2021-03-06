package com.huchx.webservice.service;

import javax.jws.WebService;

/**
 * Author: Huchx
 * Date: 2021/3/1 15:48
 */
@WebService(name = "HuchxService",//服务名
targetNamespace = "http://webservice.huchx.com"//服务命名空间
)
public interface HuchxService {
  public String sayHello(String name);
}
