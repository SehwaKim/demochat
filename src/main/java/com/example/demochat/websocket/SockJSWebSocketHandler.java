package com.example.demochat.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SockJSWebSocketHandler extends TextWebSocketHandler {
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        Principal principal = session.getPrincipal();
        String name = "";
        if(principal != null){
            name = principal.getName();
            System.out.println("접속자 : " + name);
        }
        System.out.println("------------ 새로운 웹소켓 연결 --------------");
        System.out.println("sessions.size() : " + sessions.size());
        System.out.println("session.getUri() : " + session.getUri());

        for(WebSocketSession webSocketSession : sessions){
            webSocketSession.sendMessage(new TextMessage("["+ name + "님이 입장하셨습니다.]"));
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("----------- 메세지 수신 --------------");
        Principal principal = session.getPrincipal();
        String name = "";
        String text = "";
        if(principal != null){
            name = principal.getName();
            System.out.println("sender : " + name);
        }

        // message, channel 정보
        // 받아서
        // 해당 channel 에 속한 user 들에게 뿌려야 한다.
        // online 일수도 offline 일수도

        text = message.getPayload();
        System.out.println("내용 : " + text);
        System.out.println("message.getPayloadLength() : " + message.getPayloadLength());
        System.out.println("세션 수 : "+sessions.size());
        for(WebSocketSession webSocketSession : sessions){
            webSocketSession.sendMessage(new TextMessage("[" + name + "] " + text));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Principal principal = session.getPrincipal();
        String name = "";
        if(principal != null){
            name = principal.getName();
        }
        System.out.println("------------ 연결 끊김 --------------");
        System.out.println("삭제 전 세션 갯수 : " + sessions.size());
        sessions.remove(session);
        System.out.println("삭제 후 세션 갯수 : " + sessions.size());

        for(WebSocketSession webSocketSession : sessions){
            webSocketSession.sendMessage(new TextMessage("["+ name + "님이 퇴장하셨습니다.]"));
        }
    }
}
