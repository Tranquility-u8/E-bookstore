package com.my.bookstore_backend.websocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ServerEndpoint("/bookstore/{userId}")

public class WebSocket {

    private Session session;
    private String userId;

    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();

    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="userId")String userId) {
        try {
            this.session = session;
            this.userId = userId;
            webSockets.add(this);
            sessionPool.put(userId, session);
            //log.info("size:"+webSockets.size());
        } catch (Exception e) {
        }
    }

    @OnClose
    public void onClose() {
            try {
                webSockets.remove(this);
                sessionPool.remove(this.userId);
                //log.info("size:"+ webSockets.size());
            } catch (Exception e) {
        }
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("receive:"+message);
    }

    @OnError
    public void onError(Session session, Throwable error) {

        log.error("error:"+error.getMessage());
        error.printStackTrace();
    }

    public void sendOneMessage(String userId, String message) {
        Session session = sessionPool.get(userId);
        if (session != null&&session.isOpen()) {
            try {
                log.info("sending message to user");
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
