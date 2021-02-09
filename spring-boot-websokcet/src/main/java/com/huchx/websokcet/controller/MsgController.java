package com.huchx.websokcet.controller;

import com.huchx.websokcet.endpoint.WebSocket;
import com.huchx.websokcet.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebService;

/**
 * Author: Huchx
 * Date: 2021/2/9 10:39
 */
@RestController
public class MsgController {
    @Autowired
    WebSocketService webSocketService;
    @RequestMapping("send")
    public String send(){
        return webSocketService.sendAll("Client发送的消息");
    }
}
