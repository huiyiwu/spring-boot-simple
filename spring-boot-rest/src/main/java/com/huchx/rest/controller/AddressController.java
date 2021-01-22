package com.huchx.rest.controller;

import com.huchx.rest.entity.AddressInfo;
import com.huchx.rest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Huchx
 * Date: 2021/1/22 15:05
 */
@RestController
@RequestMapping("/rest")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("/template")
    public List<AddressInfo> template(){
        return  addressService.getByTemplate();
    }

    @RequestMapping("/client")
    public List<AddressInfo> client(){
        return  addressService.getByClient();
    }
}
