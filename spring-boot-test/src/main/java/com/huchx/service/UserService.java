package com.huchx.service;

import com.huchx.pojo.UserPojo;
import org.springframework.stereotype.Service;

/**
 * Author: Huchx
 * Date: 2021/2/3 15:43
 */
@Service
public class UserService {
    public UserPojo detail(){
        return new UserPojo("huchx",26);
    }
}
