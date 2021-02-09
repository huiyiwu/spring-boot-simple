package com.huchx.websokcet.service;

import com.huchx.websokcet.client.MyWebSocketClient;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;


/**
 * Author: Huchx
 * Date: 2021/2/9 10:41
 */
@Service
public class WebSocketService {

    MyWebSocketClient webSocketClient;

    public WebSocketService() throws URISyntaxException {
        this.webSocketClient = new MyWebSocketClient("ws://10.2.96.185:8080/websocket/client");
        this.webSocketClient.connect();
    }

    public String sendAll(String msg){
        webSocketClient.send(msg);
        return "send success";
    }

    public String send(String msg){
        webSocketClient.send("HUCHX"+msg+";");
        return "send success";
    }


}
