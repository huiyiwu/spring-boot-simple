package com.huchx.websokcet.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author: Huchx
 * Date: 2021/2/9 10:47
 */
public class MyWebSocketClient extends WebSocketClient {
   private static final Log log = LogFactory.getLog(MyWebSocketClient.class);
    public MyWebSocketClient(String serverUri) throws URISyntaxException {
        super(new URI(serverUri));
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log.info("Socket连接成功");
    }

    @Override
    public void onMessage(String s) {
        log.info("Socket接收到消息："+s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        log.info("Socket关闭");
    }

    @Override
    public void onError(Exception e) {
        log.info("Socket连接失败："+e.getMessage());
    }
}
