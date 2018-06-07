package com.example.demochat.websocket;

import com.example.demochat.domain.Message;
import com.example.demochat.service.MessageService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomWebSocketHandler extends TextWebSocketHandler {
    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MessageService messageService;

    //TODO
    //RedisService
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Map<String, Object> attributes = session.getAttributes();

        Message messageNew = new Message();
        Long userId;
        String nickname = "";

        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};
        HashMap<String, Object> map = objectMapper.readValue(message.getPayload(), typeRef);

        if(attributes.get("userId") != null && attributes.get("nickname") != null){
            userId = (Long) attributes.get("userId");
            nickname = (String) attributes.get("nickname");
            messageNew.setUserId(userId);
            messageNew.setNickname(nickname);
            messageNew.setChannelId(new Long((Integer)map.get("channelId")));
            messageNew.setText((String)map.get("text"));
            messageService.addMessage(messageNew);
        }

        map.put("nickname", nickname);
        String msg = objectMapper.writeValueAsString(map);
        TextMessage textMessage = new TextMessage(msg);

        sessions.stream().forEach(s -> {
            try {
                s.sendMessage(textMessage);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }
}
