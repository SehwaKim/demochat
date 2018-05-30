package com.example.demochat.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class RawWebSocketHandler extends TextWebSocketHandler {
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("--------------------------");
        System.out.println("입장. sessions.size() : " + sessions.size());
        System.out.println("session.getHandshakeHeaders() : " + session.getHandshakeHeaders());
        System.out.println("session.getId() : " + session.getId());
        System.out.println("session.getUri() : " + session.getUri());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("--------------------------");
        System.out.println(message.getPayload());
        System.out.println("message.getPayloadLength() : " + message.getPayloadLength());
        System.out.println("메세지 전달. 세션 수 : "+sessions.size());
        /*for(WebSocketSession webSocketSession : sessions){
            webSocketSession.sendMessage(new TextMessage("Hello "));
        }*/
        session.sendMessage(new TextMessage("Hello to only me"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("--------------------------");
        System.out.println("삭제 전 세션 갯수 : " + sessions.size());
        sessions.remove(session);
        System.out.println("status.toString() : " + status.toString());
        System.out.println("삭제 후 세션 갯수 : " + sessions.size());
    }
}
