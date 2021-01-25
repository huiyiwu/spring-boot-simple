package com.huchx.validated.controller;

import com.huchx.validated.vo.UserVo;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Huchx
 * Date: 2021/1/25 9:38
 */
@RestController
public class ValidatedController {
    @RequestMapping(value = "/validate", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String validated(@Validated UserVo userVo){
        return "Validated Success";
    }
}
