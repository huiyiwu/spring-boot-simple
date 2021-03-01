package com.huchx.websokcet.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Huchx
 * Date: 2021/2/9 9:46
 */
@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocket {
    private static Logger logger = LoggerFactory.getLogger(WebSocket.class);

    // 会话，通过它给客户端发送消息
    private Session session;

    //当前连接客户端的名称
    private String name;

    private static ConcurrentHashMap<String,WebSocket> webSocKetSet = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String name){
        this.session = session;
        this.name = name;
        webSocKetSet.put(name,this);
        logger.info("[WebSocket]连接成功，当前连接人数为:{}",webSocKetSet.size());
    }

    @OnClose
    public void onClose(){
        webSocKetSet.remove(name);
        logger.info("[WebSocket] 退出成功，当前连接人数为：={}",webSocKetSet.size());
    }
    @OnMessage
    public void OnMessage(String message){
        logger.info("[WebSocket] 收到消息：{}",message);
        if (message.indexOf("HUCHX")==0){
            String name = message.substring(message.indexOf("HUCHX")+6,message.indexOf(";"));
            sendOne(name,message.substring(message.indexOf(";")+1,message.length()));
        }else {
            sendAll(message);
        }
    }

    private void sendAll(String message) {
        for (String name: webSocKetSet.keySet()){
            try {
                webSocKetSet.get(name).session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendOne(String name, String msg) {
        try {
            webSocKetSet.get(name).session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
